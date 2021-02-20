package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ro.tuc.ds2020.dtos.MedicationSDDetailsDTO;
import ro.tuc.ds2020.dtos.MedicationSDDTO;
import ro.tuc.ds2020.entities.MedicationSD;
import ro.tuc.ds2020.services.MedicationSDService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/medicationSD")
public class MedicationSDController {

    private final MedicationSDService medicationSDService;

    @Autowired
    public MedicationSDController(MedicationSDService medicationSDService) {
        this.medicationSDService = medicationSDService;
    }
    @CrossOrigin
    @GetMapping("/getMedicationSDs")
    public ResponseEntity<List<MedicationSDDetailsDTO>> getMedicationSDs() {
        List<MedicationSDDetailsDTO> dtos = medicationSDService.findMedicationSDs();
        for (MedicationSDDetailsDTO dto : dtos) {
            Link medicationSDLink = linkTo(methodOn(MedicationSDController.class)
                    .getMedicationSD(dto.getId())).withRel("medicationSDDetails");
            dto.add(medicationSDLink);
            
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value="/insertMedicationSD")
    public ResponseEntity<UUID> insertProsumer(@RequestBody MedicationSDDetailsDTO medicationSDDTO) {
        UUID medicationSDID = medicationSDService.insert(medicationSDDTO);
        return new ResponseEntity<>(medicationSDID, HttpStatus.CREATED);
    }
    @CrossOrigin
    @GetMapping(value = "/getMedicationSD/{id}")
    public ResponseEntity<MedicationSDDetailsDTO> getMedicationSD(@PathVariable("id") UUID medicationSDId) {
        MedicationSDDetailsDTO dto = medicationSDService.findMedicationSDById(medicationSDId);////
        System.out.println(dto.getName());
        MedicationSDDetailsDTO dto2=new MedicationSDDetailsDTO(dto);
        return new ResponseEntity<>(dto2, HttpStatus.OK);
    }

    //TODO: UPDATE, DELETE per resource
    @CrossOrigin
    @DeleteMapping(value = "/deleteMedicationSD")
    public ResponseEntity<String> deleteMedicationSD(@RequestBody MedicationSDDetailsDTO medicationSDDT){
    	medicationSDService.deleteById(medicationSDDT.getId());///-||-
    	return new ResponseEntity<>("Delete succesfull!", HttpStatus.OK);
    }
    @CrossOrigin
    @PostMapping(value = "/updateMedicationSD")
    public ResponseEntity<String> updateMedicationSD( @RequestBody MedicationSDDetailsDTO medicationSDDTO){
    	//System.out.println("da");
    	medicationSDService.update(medicationSDDTO.getId(), medicationSDDTO);
    	return new ResponseEntity<>("Upadte succesful!", HttpStatus.OK);
    }
    	
}
