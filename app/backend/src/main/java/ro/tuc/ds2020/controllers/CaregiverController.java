package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.services.CaregiverService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/caregiver")
public class CaregiverController {

    private final CaregiverService caregiverService;

    @Autowired
    public CaregiverController(CaregiverService caregiverService) {
        this.caregiverService = caregiverService;
    }
    @CrossOrigin
    @GetMapping("/getCaregivers")
    public ResponseEntity<List<CaregiverDetailsDTO>> getCaregivers() {
        List<CaregiverDetailsDTO> dtos = caregiverService.findCaregivers();
        for (CaregiverDetailsDTO dto : dtos) {
            Link caregiverLink = linkTo(methodOn(CaregiverController.class)
                    .getCaregiver(dto.getId())).withRel("caregiverDetails");
            dto.add(caregiverLink);
            
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping("/getPatientsForCaregiver")
    public ResponseEntity<List<PatientDetailsDTO>> getPatientsForCaregiver(@RequestBody CaregiverDetailsDTO caregiverDTO) {
        List<PatientDetailsDTO> dtos = caregiverService.findPatientsForCaregiver(caregiverDTO);
//        for (CaregiverDetailsDTO dto : dtos) {
//            Link caregiverLink = linkTo(methodOn(CaregiverController.class)
//                    .getCaregiver(dto.getId())).withRel("caregiverDetails");
//            dto.add(caregiverLink);
//            
//        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    
    
    @CrossOrigin
    @PostMapping(value="/insertCaregiver")
    public ResponseEntity<UUID> insertProsumer(@RequestBody CaregiverDetailsDTO caregiverDTO) {
        UUID caregiverID = caregiverService.insert(caregiverDTO);
        return new ResponseEntity<>(caregiverID, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping(value = "/getCaregiver/{id}")
    public ResponseEntity<CaregiverDetailsDTO> getCaregiver(@PathVariable("id") UUID caregiverId) {
        CaregiverDetailsDTO dto = caregiverService.findCaregiverById(caregiverId);////
        System.out.println(dto.getBirthdate());
        CaregiverDetailsDTO dto2=new CaregiverDetailsDTO(dto);
        return new ResponseEntity<>(dto2, HttpStatus.OK);
    }

    //TODO: UPDATE, DELETE per resource
    @CrossOrigin
    @DeleteMapping(value = "/deleteCaregiver")
    public ResponseEntity<String> deleteCaregiver(@RequestBody CaregiverDetailsDTO caregiverDT){
    	caregiverService.deleteById(caregiverDT.getId());///-||-
    	return new ResponseEntity<>("Delete succesfull!", HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value = "/updateCaregiver")
    public ResponseEntity<String> updateCaregiver( @RequestBody CaregiverDetailsDTO caregiverDTO){
    	System.out.println("dadad");
    	caregiverService.update(caregiverDTO.getId(), caregiverDTO);
    	return new ResponseEntity<>("Upadte succesful!", HttpStatus.OK);
    }
    	
}
