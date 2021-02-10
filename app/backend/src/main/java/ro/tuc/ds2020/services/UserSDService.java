package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.UserSDDTO;
import ro.tuc.ds2020.dtos.UserSDDTO;
import ro.tuc.ds2020.dtos.UserSDDetailsDTO;
import ro.tuc.ds2020.dtos.builders.PatientBuilder;
import ro.tuc.ds2020.dtos.builders.UserSDBuilder;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.UserSD;
import ro.tuc.ds2020.repositories.CaregiverRepository;
import ro.tuc.ds2020.repositories.DoctorRepository;
import ro.tuc.ds2020.repositories.UserSDRepository;
import ro.tuc.ds2020.repositories.PatientRepository;
import ro.tuc.ds2020.repositories.UserSDRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserSDService {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserSDService.class);
    private final UserSDRepository userSDRepository;
    
    @Autowired
    
    public UserSDService(UserSDRepository userSDRepository) {
        this.userSDRepository=userSDRepository;
       
    }

    public String findUser(String username, String password, String role) {
    	UserSD user=null;
    	user=userSDRepository.findByUsername(username);
    	if(user!=null && user.getPassword()==password && user.getRole()==role) {
    		return "found";
    	}
    	else return "not found";
    }
 
    public UUID insert(UserSDDetailsDTO user) {
    	System.out.println("*************service: "+user.toString());
    	UserSD entity=UserSDBuilder.toEntity(user);
    	entity =userSDRepository.save(entity);
        LOGGER.debug("User with id {} was inserted in db", entity.getId());
        return entity.getId();
    }

}
