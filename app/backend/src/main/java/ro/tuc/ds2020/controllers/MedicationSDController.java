package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.MedicationSDDTO;
import ro.tuc.ds2020.dtos.MedicationSDDetailsDTO;
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

    @GetMapping()
    public ResponseEntity<List<MedicationSDDTO>> getMedicationSDs() {
        List<MedicationSDDTO> dtos = medicationSDService.findMedicationSDs();
        for (MedicationSDDTO dto : dtos) {
            Link medicationSDLink = linkTo(methodOn(MedicationSDController.class)
                    .getMedicationSD(dto.getId())).withRel("medicationSDDetails");
            dto.add(medicationSDLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody MedicationSDDetailsDTO medicationSDDTO) {
        UUID medicationSDID = medicationSDService.insert(medicationSDDTO);
        return new ResponseEntity<>(medicationSDID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicationSDDetailsDTO> getMedicationSD(@PathVariable("id") UUID medicationSDId) {
        MedicationSDDetailsDTO dto = medicationSDService.findMedicationSDById(medicationSDId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //TODO: UPDATE, DELETE per resource

}
