package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.dtos.builders.CaregiverBuilder;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.CaregiverRepository;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class CaregiverService {
    private static final Logger LOGGER = LoggerFactory.getLogger(CaregiverService.class);
    private final CaregiverRepository caregiverRepository;
    private final PatientRepository patientRepository;

    @Autowired
    public CaregiverService(CaregiverRepository caregiverRepository,PatientRepository patientRepository) {
        this.caregiverRepository = caregiverRepository;
        this.patientRepository=patientRepository;
    }

    public List<CaregiverDetailsDTO> findCaregivers() {
        List<Caregiver> caregiverList = caregiverRepository.findAll();
        for(Caregiver c:caregiverList) {
        	List<Patient> patientsList=patientRepository.getPatientsForCaregiver(c.getName());
        	c.setPatients(patientsList);
        }
        
        return caregiverList.stream()
                .map(CaregiverBuilder::toCaregiverDetailsDTO)
                .collect(Collectors.toList());
    }
    
    public List<PatientDetailsDTO> findPatientsForCaregiver(String care) {

        	List<Patient> patientsList=patientRepository.getPatientsForCaregiver(care);

        	return patientsList.stream()
                    .map(PatientBuilder::toPatientDetailsDTO)
                    .collect(Collectors.toList());

    }
    
    public CaregiverDTO findCaregiverByName(String name) {
        Optional<Caregiver> prosumerOptional = Optional.ofNullable(caregiverRepository.findByName(name));
        if (!prosumerOptional.isPresent()) {
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with name: " + name);
        }
        return CaregiverBuilder.toCaregiverDTO(prosumerOptional.get());
    }
    
    public CaregiverDetailsDTO findCaregiverById(UUID id) {
        Optional<Caregiver> prosumerOptional = caregiverRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Caregiver with id {} was not found in db", id);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + id);
        }
        System.out.println(prosumerOptional.get().getAddress()+"  ..........   "+id);
        return CaregiverBuilder.toCaregiverDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(CaregiverDetailsDTO caregiverDTO) {
    	Caregiver caregiver = CaregiverBuilder.toEntity(caregiverDTO);
    	
    	caregiver =caregiverRepository.save(caregiver);
        LOGGER.debug("Caregiver with id {} was inserted in db", caregiver.getId());
        return caregiver.getId();
    }

    public void deleteById(UUID id) {
    	 Optional<Caregiver> prosumerOptional = caregiverRepository.findById(id);
         if (!prosumerOptional.isPresent()) {
             LOGGER.error("Caregiver with id {} was not found in db", id);
             throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + id);
         }else {
        	 caregiverRepository.deleteById(id);
         }
    }
    
    public void deleteByName(String name) {
   	 Caregiver prosumerOptional = caregiverRepository.findByName(name);
        if (prosumerOptional==null) {
            LOGGER.error("Caregiver with name {} was not found in db", name);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with name: " + name);
        }else {
        	caregiverRepository.delete(prosumerOptional);
        }
   }
    
    
    public void update(UUID id,CaregiverDetailsDTO caregiver) {
    	System.out.println(id.toString());
   	 	Optional<Caregiver> prosumerOptional = caregiverRepository.findById(id);
   	 
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("Caregiver with id {} was not found in db", id);
            throw new ResourceNotFoundException(Caregiver.class.getSimpleName() + " with id: " + id);
        }else {
        //	caregiverRepository.update(id,name,birthday,gender,address,patients);
        	Caregiver c=prosumerOptional.get();
        	c.setName(caregiver.getName());
        	c.setBirthdate(caregiver.getBirthdate());
        	c.setAddress(caregiver.getAddress());
        	c.setGender(caregiver.getGender());
        	c.setRole(caregiver.getRole());
        	c=caregiverRepository.save(c); System.out.println("Caregiver "+ caregiver.getName()+" was updated");
        }
   }
    
    public Caregiver findByName(String name){
        return caregiverRepository.findByName(name);
    }
    
    public boolean checkExistsByUsername(String username) {
    	return caregiverRepository.existsByName(username);
    }
}
