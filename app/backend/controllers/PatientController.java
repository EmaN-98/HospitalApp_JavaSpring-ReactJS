package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.services.PatientService;
import ro.tuc.ds2020.services.PatientService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/patient")
public class PatientController {

    private final PatientService patientService;

    @Autowired
    public PatientController(PatientService patientService) {
        this.patientService = patientService;
    }
    @CrossOrigin
    @GetMapping("/getPatients")
    public ResponseEntity<List<PatientDetailsDTO>> getPatients() {
        List<PatientDetailsDTO> dtos = patientService.findPatients();
        for (PatientDetailsDTO dto : dtos) {
            Link patientLink = linkTo(methodOn(PatientController.class)
                    .getPatient(dto.getId())).withRel("patientDetails");
            dto.add(patientLink);
            
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value="/insertPatient")
    public ResponseEntity<UUID> insertProsumer(@RequestBody PatientDetailsDTO patientDTO) {
        UUID patientID = patientService.insert(patientDTO);
        return new ResponseEntity<>(patientID, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping(value = "/getPatient/{id}")
    public ResponseEntity<PatientDetailsDTO> getPatient(@PathVariable("id") UUID patientId) {
        PatientDetailsDTO dto = patientService.findPatientById(patientId);////
        System.out.println(dto.getBirthdate());
        PatientDetailsDTO dto2=new PatientDetailsDTO(dto);
        return new ResponseEntity<>(dto2, HttpStatus.OK);
    }
    
    @CrossOrigin
    @GetMapping(value = "/getDetailsForPatient/{name}")
    public ResponseEntity<PatientDetailsDTO> getDetailsForPatient(@PathVariable("name") String name) {
    	//System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$");
        PatientDetailsDTO dto = patientService.findPatientByName(name);////
        //System.out.println(dto.getBirthdate());
        PatientDetailsDTO dto2=new PatientDetailsDTO(dto);
        return new ResponseEntity<>(dto2, HttpStatus.OK);
    }

    //TODO: UPDATE, DELETE per resource
    @CrossOrigin
    @DeleteMapping(value = "/deletePatient")
    public ResponseEntity<String> deletePatient(@RequestBody PatientDetailsDTO patientDT){
    	patientService.deleteById(patientDT.getId());///-||-
    	return new ResponseEntity<>("Delete succesfull!", HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value = "/updatePatient")
    public ResponseEntity<String> updatePatient( @RequestBody PatientDetailsDTO patientDTO){
    	System.out.println("dadad");
    	patientService.update(patientDTO.getId(), patientDTO);
    	return new ResponseEntity<>("Upadte succesful!", HttpStatus.OK);
    }
    	
}
