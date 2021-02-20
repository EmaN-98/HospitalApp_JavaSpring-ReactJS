package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.tuc.ds2020.dtos.Msg;
import ro.tuc.ds2020.dtos.UserSDDTO;
import ro.tuc.ds2020.dtos.UserSDDTO;
import ro.tuc.ds2020.dtos.UserSDDetailsDTO;
import ro.tuc.ds2020.entities.UserSD;
import ro.tuc.ds2020.services.UserSDService;
import ro.tuc.ds2020.services.UserSDService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/login")
public class UserSDController {

    private final UserSDService userSDService;
	
	 @Autowired
	    public UserSDController(UserSDService userSDService) {
	        this.userSDService = userSDService;
	    }
	 
	 	//@CrossOrigin
	 	@PostMapping(value = "/loginUser")
	    public ResponseEntity<?> getUserSD(@RequestBody UserSDDetailsDTO userSDDTO) {
		 System.out.println("---------controller: "+userSDDTO.toString());
	        String ok = userSDService.findUser(userSDDTO.getUsername(),userSDDTO.getPassword(),userSDDTO.getRole());
	      //  System.out.println("---------controller: founnnnd/not");////
	        if(ok=="found") return new ResponseEntity<>(userSDDTO.getRole(),HttpStatus.OK);
	     //   if(ok=="found") return new ResponseEntity<>(new Msg("DADADADA"),HttpStatus.OK);
	        else return new ResponseEntity<>("UserIncorrect",HttpStatus.OK);
	    }
	 
	 	//@CrossOrigin
	    @PostMapping(value="/registerUser")
	    public ResponseEntity<UUID> insertProsumer(@RequestBody UserSDDetailsDTO userSDDTO) {
		// System.out.println("***********controller: "+userSDDTO.toString());
	        UUID userSDID = userSDService.insert(userSDDTO);
	        return new ResponseEntity<>(userSDID, HttpStatus.CREATED);
	    }

}
