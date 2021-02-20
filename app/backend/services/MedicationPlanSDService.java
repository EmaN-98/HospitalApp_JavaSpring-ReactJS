package ro.tuc.ds2020.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.tuc.ds2020.controllers.handlers.exceptions.model.ResourceNotFoundException;
import ro.tuc.ds2020.dtos.MedicationPlanSDDTO;
import ro.tuc.ds2020.dtos.MedicationPlanSDDetailsDTO;
import ro.tuc.ds2020.dtos.builders.MedicationPlanSDBuilder;
import ro.tuc.ds2020.entities.MedicationPlanSD;
import ro.tuc.ds2020.repositories.MedicationPlanSDRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MedicationPlanSDService {
    private static final Logger LOGGER = LoggerFactory.getLogger(MedicationPlanSDService.class);
    private final MedicationPlanSDRepository medicationPlanSDRepository;

    @Autowired
    public MedicationPlanSDService(MedicationPlanSDRepository medicationPlanSDRepository) {
        this.medicationPlanSDRepository = medicationPlanSDRepository;
    }

    public List<MedicationPlanSDDTO> findMedicationPlanSDs() {
        List<MedicationPlanSD> medicationPlanSDList = medicationPlanSDRepository.findAll();
        return medicationPlanSDList.stream()
                .map(MedicationPlanSDBuilder::toMedicationPlanSDDTO)
                .collect(Collectors.toList());
    }

    public MedicationPlanSDDetailsDTO findMedicationPlanSDById(UUID id) {
        Optional<MedicationPlanSD> prosumerOptional = medicationPlanSDRepository.findById(id);
        if (!prosumerOptional.isPresent()) {
            LOGGER.error("MedicationPlanSD with id {} was not found in db", id);
            throw new ResourceNotFoundException(MedicationPlanSD.class.getSimpleName() + " with id: " + id);
        }
        return MedicationPlanSDBuilder.toMedicationPlanSDDetailsDTO(prosumerOptional.get());
    }

    public UUID insert(MedicationPlanSDDetailsDTO medicationPlanSDDTO) {
    	MedicationPlanSD medicationPlanSD = MedicationPlanSDBuilder.toEntity(medicationPlanSDDTO);
    	medicationPlanSD =medicationPlanSDRepository.save(medicationPlanSD);
        LOGGER.debug("MedicationPlanSD with id {} was inserted in db", medicationPlanSD.getId());
        return medicationPlanSD.getId();
    }

}
