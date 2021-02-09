package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.dtos.DoctorDetailsDTO;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.services.DoctorService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/doctor")
public class DoctorController {

    private final DoctorService doctorService;

    @Autowired
    public DoctorController(DoctorService doctorService) {
        this.doctorService = doctorService;
    }

    @GetMapping()
    public ResponseEntity<List<DoctorDTO>> getDoctors() {
        List<DoctorDTO> dtos = doctorService.findDoctors();
        for (DoctorDTO dto : dtos) {
            Link doctorLink = linkTo(methodOn(DoctorController.class)
                    .getDoctor(dto.getId())).withRel("doctorDetails");
            dto.add(doctorLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody DoctorDetailsDTO doctorDTO) {
        UUID doctorID = doctorService.insert(doctorDTO);
        return new ResponseEntity<>(doctorID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<DoctorDetailsDTO> getDoctor(@PathVariable("id") UUID doctorId) {
        DoctorDetailsDTO dto = doctorService.findDoctorById(doctorId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //TODO: UPDATE, DELETE per resource

}
