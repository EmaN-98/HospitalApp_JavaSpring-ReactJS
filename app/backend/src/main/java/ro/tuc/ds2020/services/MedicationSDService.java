package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.MedicationSDDTO;
import ro.tuc.ds2020.dtos.MedicationSDDetailsDTO;
import ro.tuc.ds2020.dtos.builders.MedicationSDBuilder;
import ro.tuc.ds2020.entities.MedicationSD;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.repositories.MedicationSDRepository;
import ro.tuc.ds2020.repositories.PatientRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicationSDService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationSDService.class);
    private final MedicationSDRepository medicationSDRepository;

    @Autowired
    public MedicationSDService(MedicationSDRepository medicationSDRepository) {
        this.medicationSDRepository = medicationSDRepository;
    }

    public List<MedicationSDDetailsDTO> findMedicationSDs() {
        List<MedicationSD> medicationSDList = medicationSDRepository.findAll();
       return medicationSDList.stream()
                .map(MedicationSDBuilder::toMedicationSDDetailsDTO)
                .collect(Collectors.toList());
    }
    
    public MedicationSDDTO findMedicationSDByName(String name) {
        Optional<MedicationSD> prosumerOptional = Optional.ofNullable(medicationSDRepository.findByName(name));
        if (!prosumerOptional.isPresent()) {
            throw new ResourceNotFoundException(MedicationSD.class.getSimpleName() + " with name: " + name);
        }
        return MedicationSDBuilder.toMedicationSDDTO(prosumerOptional.get());
    }
    
    public MedicationSDDetailsDTO findMedicationSDById(UUID id) {
        Optional<MedicationSD> prosumerOptional = medicationSDRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("MedicationSD with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationSD.class.getSimpleName() + " with id: " + id);
        }
        System.out.println(prosumerOptional.get().getName()+"  ..........   "+id);
        return MedicationSDBuilder.toMedicationSDDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(MedicationSDDetailsDTO medicationSDDTO) {
    	MedicationSD medicationSD = MedicationSDBuilder.toEntity(medicationSDDTO);
    	
    	medicationSD =medicationSDRepository.save(medicationSD);
        LOGGER.debug("MedicationSD with id {} was inserted in db", medicationSD.getId());
        return medicationSD.getId();
    }

    public void deleteById(UUID id) {
    	 Optional<MedicationSD> prosumerOptional = medicationSDRepository.findById(id);
         if (!prosumerOptional.isPresent()) {
             LOGGER.error("MedicationSD with id {} was not found in db", id);
             throw new ResourceNotFoundException(MedicationSD.class.getSimpleName() + " with id: " + id);
         }else {
        	 medicationSDRepository.deleteById(id);
         }
    }
    
    public void deleteByName(String name) {
   	 MedicationSD prosumerOptional = medicationSDRepository.findByName(name);
        if (prosumerOptional==null) {
            LOGGER.error("MedicationSD with name {} was not found in db", name);
            throw new ResourceNotFoundException(MedicationSD.class.getSimpleName() + " with name: " + name);
        }else {
        	medicationSDRepository.delete(prosumerOptional);
        }
   }
    
    
    public void update(UUID id,MedicationSDDetailsDTO medicationSD) {
    	System.out.println(id.toString());
   	 	Optional<MedicationSD> prosumerOptional = medicationSDRepository.findById(id);
   	 
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("MedicationSD with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationSD.class.getSimpleName() + " with id: " + id);
        }else {
        //	medicationSDRepository.update(id,name,birthday,gender,address,patients);
        	MedicationSD c=prosumerOptional.get();
        	c.setName(medicationSD.getName());
        	c.setDosage(medicationSD.getDosage());
        	c.setSideEffects(medicationSD.getSideEffects());
        	c.setIntake_interval(medicationSD.getIntake_interval());
        	c=medicationSDRepository.save(c); System.out.println("MedicationSD "+ medicationSD.getName()+" was updated");
        }
   }
    
    public MedicationSD findByName(String name){
        return medicationSDRepository.findByName(name);
    }
    
//    public boolean checkExistsByUsername(String username) {
//    	return medicationSDRepository.existsByName(username);
//    }
}