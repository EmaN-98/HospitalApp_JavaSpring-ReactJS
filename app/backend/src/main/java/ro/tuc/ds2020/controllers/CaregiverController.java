package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
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

    @GetMapping("/getCaregivers")
    public ResponseEntity<List<CaregiverDTO>> getCaregivers() {
        List<CaregiverDTO> dtos = caregiverService.findCaregivers();
        for (CaregiverDTO dto : dtos) {
            Link caregiverLink = linkTo(methodOn(CaregiverController.class)
                    .getCaregiver(dto.getId())).withRel("caregiverDetails");
            dto.add(caregiverLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping(value="/insertCaregiver")
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody CaregiverDetailsDTO caregiverDTO) {
        UUID caregiverID = caregiverService.insert(caregiverDTO);
        return new ResponseEntity<>(caregiverID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getCaregiver/{id}")
    public ResponseEntity<CaregiverDetailsDTO> getCaregiver(@PathVariable("id") UUID caregiverId) {
        CaregiverDetailsDTO dto = caregiverService.findCaregiverById(caregiverId);////
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //TODO: UPDATE, DELETE per resource
    
    @DeleteMapping(value = "/deleteCaregiver/{id}")
    public ResponseEntity<UUID> deleteCaregiver(@PathVariable("id") UUID caregiverId){
    	caregiverService.deleteById(caregiverId);///-||-
    	return new ResponseEntity<>(caregiverId, HttpStatus.OK);
    }

    @PutMapping(value="/updateCaregiver/{id}")
    public ResponseEntity<UUID> updateCaregiver(@PathVariable("id") UUID caregiverId, @Valid @RequestBody CaregiverDetailsDTO caregiverDTO){
    	caregiverService.update(caregiverId, caregiverDTO);
    	return new ResponseEntity<>(caregiverId, HttpStatus.OK);
    }
    	
}
