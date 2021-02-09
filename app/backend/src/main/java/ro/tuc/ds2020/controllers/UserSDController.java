package ro.tuc.ds2020.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ro.tuc.ds2020.dtos.UserSDDTO;
import ro.tuc.ds2020.dtos.UserSDDetailsDTO;
import ro.tuc.ds2020.entities.UserSD;
import ro.tuc.ds2020.services.UserSDService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@CrossOrigin
@RequestMapping(value = "/userSD")
public class UserSDController {

    private final UserSDService userSDService;

    @Autowired
    public UserSDController(UserSDService userSDService) {
        this.userSDService = userSDService;
    }

    @GetMapping()
    public ResponseEntity<List<UserSDDTO>> getUserSDs() {
        List<UserSDDTO> dtos = userSDService.findUserSDs();
        for (UserSDDTO dto : dtos) {
            Link userSDLink = linkTo(methodOn(UserSDController.class)
                    .getUserSD(dto.getId())).withRel("userSDDetails");
            dto.add(userSDLink);
        }
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<UUID> insertProsumer(@Valid @RequestBody UserSDDetailsDTO userSDDTO) {
        UUID userSDID = userSDService.insert(userSDDTO);
        return new ResponseEntity<>(userSDID, HttpStatus.CREATED);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<UserSDDetailsDTO> getUserSD(@PathVariable("id") UUID userSDId) {
        UserSDDetailsDTO dto = userSDService.findUserSDById(userSDId);
        return new ResponseEntity<>(dto, HttpStatus.OK);
    }

    //TODO: UPDATE, DELETE per resource

}
