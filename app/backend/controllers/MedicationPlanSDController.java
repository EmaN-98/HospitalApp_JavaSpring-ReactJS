package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.MedicationPlanSDDTO;
import ro.tuc.ds2020.dtos.MedicationPlanSDDetailsDTO;
import ro.tuc.ds2020.entities.MedicationPlanSD;
import ro.tuc.ds2020.services.MedicationPlanSDService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/medicationPlanSD")
public class MedicationPlanSDController {

    private final MedicationPlanSDService medicationPlanSDService;

    @Autowired
    public MedicationPlanSDController(MedicationPlanSDService medicationPlanSDService) {
        this.medicationPlanSDService = medicationPlanSDService;
    }

    @GetMapping()
    public ResponseEntity<List<MedicationPlanSDDTO>> getMedicationPlanSDs() {
        List<MedicationPlanSDDTO> dtos = medicationPlanSDService.findMedicationPlanSDs();
        for (MedicationPlanSDDTO dto : dtos) {
            Link medicationPlanSDLink = linkTo(methodOn(MedicationPlanSDController.class)
                    .getMedicationPlanSD(dto.getId())).withRel("medicationPlanSDDetails");
            dto.add(medicationPlanSDLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody MedicationPlanSDDetailsDTO medicationPlanSDDTO) {
        UUID medicationPlanSDID = medicationPlanSDService.insert(medicationPlanSDDTO);
        return new ResponseEntity<>(medicationPlanSDID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MedicationPlanSDDetailsDTO> getMedicationPlanSD(@PathVariable("id") UUID medicationPlanSDId) {
        MedicationPlanSDDetailsDTO dto = medicationPlanSDService.findMedicationPlanSDById(medicationPlanSDId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //TODO: UPDATE, DELETE per resource

}
