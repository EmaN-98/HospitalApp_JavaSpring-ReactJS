package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.UserSDDTO;
import ro.tuc.ds2020.dtos.UserSDDetailsDTO;
import ro.tuc.ds2020.dtos.builders.UserSDBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.UserSD;
import ro.tuc.ds2020.repositories.CaregiverRepository;
import ro.tuc.ds2020.repositories.DoctorRepository;
import ro.tuc.ds2020.repositories.PatientRepository;
import ro.tuc.ds2020.repositories.UserSDRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserSDService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSDService.class);
   /* private final DoctorRepository doctorRepository;
    private final CaregiverRepository caregiverRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public UserSDService(DoctorRepository doctorRepository, CaregiverRepository caregiverRepository, PatientRepository patientRepository) {
        this.doctorRepository = doctorRepository;
        this.caregiverRepository = caregiverRepository;
        this.patientRepository = patientRepository;
    }

    public LoginDTO login(String username, String password){

        Doctor doctor =doctorRepository.findByName(username).orElse(null);
        if((doctor != null) && (doctorRepository.existsByPassword(password))){
            return new LoginDTO(doctor.getName(), doctor.getPassword(), doctor.getRole());
        }

        Caregiver caregiver = caregiverRepository.findByName(username);
        if((caregiver != null) && (caregiverRepository.existsByPassword(password))){
            return new LoginDTO(caregiver.getName(), caregiver.getPassword(), caregiver.getRole());
        }
        Patient patient = patientRepository.findByName(username);
        if((patient != null) && (patientRepository.existsByPassword(password))){
            return new LoginDTO(patient.getName(), patient.getPassword(), patient.getRole());
        }

        System.out.println("This user doesn't exist in the database ");
        return null;
    }

    public RegisterDTO register(String name, String password, String birthdate, String gender, String address, String role){

        if(role.equals("doctor")){
            Doctor medicalDoctor = new Doctor(name, password, birthdate, gender, address, role);
            doctorRepository.save(doctor);

            return new RegisterDTO(medicalDoctor.getName(), medicalDoctor.getPassword(), medicalDoctor.getBirthdate(),
                    medicalDoctor.getGender(), medicalDoctor.getAddress(), medicalDoctor.getRole());
        }
        if(role.equals("caregiver")){
            Caregiver caregiver = new Caregiver(name, password, birthdate, gender, address, role);
            caregiverRepository.save(caregiver);
            return new RegisterDTO(caregiver.getName(), caregiver.getPassword(), caregiver.getBirthdate(), caregiver.getGender(),
                    caregiver.getAddress(), caregiver.getRole());
        }
        if(role.equals("patient")){
            Patient patient = new Patient(name, password, birthdate, gender, address, role);
            patientRepository.save(patient);
            return new RegisterDTO(patient.getName(), patient.getPassword(), patient.getBirthdate(), patient.getGender(),
                    patient.getAddress(), patient.getRole());
        }

        System.out.println("Error ");
        return null;
    }*/
     private final UserSDRepository userSDRepository;

    @Autowired
    public UserSDService(UserSDRepository userSDRepository) {
        this.userSDRepository = userSDRepository;
    }

    public List<UserSDDTO> findUserSDs() {
        List<UserSD> userSDList = userSDRepository.findAll();
        return userSDList.stream()
                .map(UserSDBuilder::toUserSDDTO)
                .collect(Collectors.toList());
    }

    public UserSDDetailsDTO findUserSDById(UUID id) {
        Optional<UserSD> prosumerOptional = userSDRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("UserSD with id {} was not found in db", id);
            throw new ResourceNotFoundException(UserSD.class.getSimpleName() + " with id: " + id);
        }
        return UserSDBuilder.toUserSDDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(UserSDDetailsDTO userSDDTO) {
    	UserSD userSD = UserSDBuilder.toEntity(userSDDTO);
    	userSD =userSDRepository.save(userSD);
        LOGGER.debug("UserSD with id {} was inserted in db", userSD.getId());
        return userSD.getId();
    }

}
