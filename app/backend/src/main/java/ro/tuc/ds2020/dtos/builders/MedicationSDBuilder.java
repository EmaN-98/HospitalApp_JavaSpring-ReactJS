package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;

import java.util.ArrayList;

import ro.tuc.ds2020.dtos.MedicationSDDTO;
import ro.tuc.ds2020.dtos.MedicationSDDetailsDTO;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.MedicationSD;

public class MedicationSDBuilder {

    private MedicationSDBuilder() {
    }

    public static MedicationSDDTO toMedicationSDDTO(MedicationSD medicationSD) {
        return new MedicationSDDTO(medicationSD.getId(), medicationSD.getName(), medicationSD.getDosage(), medicationSD.getIntake_interval());
    }

    public static MedicationSDDetailsDTO toMedicationSDDetailsDTO(MedicationSD medicationSD) {
        return new MedicationSDDetailsDTO(medicationSD.getId(), medicationSD.getName(), medicationSD.getSideEffects(), medicationSD.getDosage(), medicationSD.getIntake_interval());
    }

    public static MedicationSD toEntity(MedicationSDDetailsDTO medicationSDDetailsDTO) {
        return new MedicationSD(medicationSDDetailsDTO.getName(),
        		medicationSDDetailsDTO.getSideEffects(),
        		medicationSDDetailsDTO.getDosage(),
        		medicationSDDetailsDTO.getIntake_interval(), null);
    }
}
