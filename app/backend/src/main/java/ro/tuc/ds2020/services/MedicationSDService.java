package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.MedicationSDDTO;
import ro.tuc.ds2020.dtos.MedicationSDDetailsDTO;
import ro.tuc.ds2020.dtos.builders.MedicationSDBuilder;
import ro.tuc.ds2020.entities.MedicationSD;
import ro.tuc.ds2020.repositories.MedicationSDRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicationSDService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationSDService.class);
    private final MedicationSDRepository medicationSDRepository;

    @Autowired
    public MedicationSDService(MedicationSDRepository medicationSDRepository) {
        this.medicationSDRepository = medicationSDRepository;
    }

    public List<MedicationSDDTO> findMedicationSDs() {
        List<MedicationSD> medicationSDList = medicationSDRepository.findAll();
        return medicationSDList.stream()
                .map(MedicationSDBuilder::toMedicationSDDTO)
                .collect(Collectors.toList());
    }

    public MedicationSDDetailsDTO findMedicationSDById(UUID id) {
        Optional<MedicationSD> prosumerOptional = medicationSDRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("MedicationSD with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationSD.class.getSimpleName() + " with id: " + id);
        }
        return MedicationSDBuilder.toMedicationSDDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(MedicationSDDetailsDTO medicationSDDTO) {
    	MedicationSD medicationSD = MedicationSDBuilder.toEntity(medicationSDDTO);
    	medicationSD =medicationSDRepository.save(medicationSD);
        LOGGER.debug("MedicationSD with id {} was inserted in db", medicationSD.getId());
        return medicationSD.getId();
    }

}
