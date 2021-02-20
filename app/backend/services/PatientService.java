package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.PatientRepository;
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
    private final CaregiverRepository caregiverRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public PatientService(PatientRepository patientRepository,DoctorRepository doctorRepository,DoctorRepository doctorRepository2,CaregiverRepository caregiverRepository,CaregiverRepository caregiverRepository2) {
        this.patientRepository = patientRepository;
        this.doctorRepository = doctorRepository2;
        this.caregiverRepository = caregiverRepository2;
    }

    public List<PatientDetailsDTO> findPatients() {
        List<Patient> patientList = patientRepository.findAll();
        for(Patient c:patientList) {
        	//List<Patient> patientsList=patientRepository.getPatientsForPatient(c.getName());
        	//c.setPatients(patientsList);
        }
        
        return patientList.stream()
                .map(PatientBuilder::toPatientDetailsDTO)
                .collect(Collectors.toList());
    }
    
  
    
    public PatientDetailsDTO findPatientById(UUID id) {
        Optional<Patient> prosumerOptional = patientRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Patient with id {} was not found in db", id);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
        }
        System.out.println(prosumerOptional.get().getAddress()+"  ..........   "+id);
        return PatientBuilder.toPatientDetailsDTO(prosumerOptional.get());
    }
//    
//    public PatientDTO findPatientByName(String name) {
//        Optional<Patient> prosumerOptional = Optional.ofNullable(patientRepository.findByName(name));
//        if (!prosumerOptional.isPresent()) {
//            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with name: " + name);
//        }
//        return PatientBuilder.toPatientDTO(prosumerOptional.get());
//    }
//    
    public PatientDetailsDTO findPatientByName(String name) {
        Optional<Patient> prosumerOptional = Optional.ofNullable(patientRepository.findByName(name));
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Patient with name {} was not found in db", name);
            System.out.println("  ..........");
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with name: " + name);
        }
        System.out.println(prosumerOptional.get().getAddress()+"  ..........   "+name);
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
    
    
    public void update(UUID id,PatientDetailsDTO patient) {
    	System.out.println(id.toString());
   	 	Optional<Patient> prosumerOptional = patientRepository.findById(id);
   	 
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Patient with id {} was not found in db", id);
            throw new ResourceNotFoundException(Patient.class.getSimpleName() + " with id: " + id);
        }else {
        //	patientRepository.update(id,name,birthday,gender,address,patients);
        	Patient c=prosumerOptional.get();
        	c.setName(patient.getName());
        	c.setBirthdate(patient.getBirthdate());
        	c.setAddress(patient.getAddress());
        	c.setGender(patient.getGender());
        	c.setRole(patient.getRole());
        	c=patientRepository.save(c); System.out.println("Patient "+ patient.getName()+" was updated");
        }
   }
    
    public Patient findByName(String name){
        return patientRepository.findByName(name);
    }
    
    public boolean checkExistsByUsername(String username) {
    	return patientRepository.existsByName(username);
    }
}