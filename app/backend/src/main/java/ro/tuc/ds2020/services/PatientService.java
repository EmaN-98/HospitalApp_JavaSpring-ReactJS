package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.CaregiverRepository;
import ro.tuc.ds2020.repositories.DoctorRepository;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PatientService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PatientService.class);
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;
    private final CaregiverRepository caregiverRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository,DoctorRepository doctorRepository,DoctorRepository doctorRepository2,CaregiverRepository caregiverRepository,CaregiverRepository caregiverRepository2) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository2;
        this.caregiverRepository = caregiverRepository2;
    }

    public List<PatientDTO> findPatients() {
        List<Patient> patientList = patientRepository.findAll();
        return patientList.stream()
                .map(PatientBuilder::toPatientDTO)
                .collect(Collectors.toList());
    }

    public PatientDetailsDTO findPatientById(UUID id) {
        Optional<Patient> prosumerOptional = patientRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Patient with id {} was not found in db", id);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
        }
        return PatientBuilder.toPatientDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(PatientDetailsDTO patientDTO) {
    	Patient patient = PatientBuilder.toEntity(patientDTO);
    	patient =patientRepository.save(patient);
        LOGGER.debug("Patient with id {} was inserted in db", patient.getId());
        return patient.getId();
    }

    public void deleteById(UUID id) {
   	 Optional<Patient> prosumerOptional = patientRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Patient with id {} was not found in db", id);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
        }else {
       	 patientRepository.deleteById(id);
        }
   }
   
   public void deleteByName(String name) {
  	 Patient prosumerOptional = patientRepository.findByName(name);
       if (prosumerOptional==null) {
           LOGGER.error("Patient with name {} was not found in db", name);
           throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with name: " + name);
       }else {
       	patientRepository.delete(prosumerOptional);
       }
  }
   
   
   public void update(UUID id,String name,String birthdate,String gender,String address,String medical_record,UUID doctorId,UUID caregiverId,String role) {
  	 Optional<Patient> prosumerOptional = patientRepository.findById(id);
       if (!prosumerOptional.isPresent()) {
           LOGGER.error("Patient with id {} was not found in db", id);
           throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
       }else {
       //	patientRepository.update(id,name,birthday,gender,address,patients);
       	Patient p=patientRepository.findByName(name);
       	p.setName(name);
       	p.setBirthdate(birthdate);
       	p.setAddress(address);
       	p.setGender(gender);
       	Caregiver c=caregiverRepository.findById(caregiverId).get();
       	Doctor d=doctorRepository.findById(doctorId).get();
       	p.setCaregiver(c);
       	p.setDoctor(d);
       	c.setRole(role);
       	p=patientRepository.save(p); System.out.println("Patient "+ name+" was updated");
       }
  }
   
   public Patient findByName(String name){
       return patientRepository.findByName(name);
   }
   
   public boolean checkExistsByUsername(String username) {
   	return patientRepository.existsByName(username);
   }
}
