package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;

import java.util.ArrayList;

import ro.tuc.ds2020.dtos.MedicationPlanSDDTO;
import ro.tuc.ds2020.dtos.MedicationPlanSDDetailsDTO;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.MedicationPlanSD;

public class MedicationPlanSDBuilder {

    private MedicationPlanSDBuilder() {
    }

    public static MedicationPlanSDDTO toMedicationPlanSDDTO(MedicationPlanSD medicationPlanSD) {
        return new MedicationPlanSDDTO(medicationPlanSD.getId(), medicationPlanSD.getMedication_list());
    }

    public static MedicationPlanSDDetailsDTO toMedicationPlanSDDetailsDTO(MedicationPlanSD medicationPlanSD) {
        return new MedicationPlanSDDetailsDTO(medicationPlanSD.getId(), medicationPlanSD.getMedication_list(), medicationPlanSD.getStart_med(), medicationPlanSD.getEnd_med());
    }

    public static MedicationPlanSD toEntity(MedicationPlanSDDetailsDTO medicationPlanSDDetailsDTO) {
        return new MedicationPlanSD(medicationPlanSDDetailsDTO.getMedication_list(),
        		medicationPlanSDDetailsDTO.getStart_med(),
        		medicationPlanSDDetailsDTO.getEnd_med());
    }
}
