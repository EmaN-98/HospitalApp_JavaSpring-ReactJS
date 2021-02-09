package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;

import java.util.ArrayList;

import ro.tuc.ds2020.dtos.CaregiverDTO;
import ro.tuc.ds2020.dtos.CaregiverDetailsDTO;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Patient;

public class CaregiverBuilder {

    private CaregiverBuilder() {
    }

    public static CaregiverDTO toCaregiverDTO(Caregiver caregiver) {
        return new CaregiverDTO(caregiver.getId(), caregiver.getName(), caregiver.getPatients());
    }

    public static CaregiverDetailsDTO toCaregiverDetailsDTO(Caregiver caregiver) {
        return new CaregiverDetailsDTO(caregiver.getId(), caregiver.getName(), caregiver.getBirthdate(), caregiver.getGender(), caregiver.getAddress(),  caregiver.getPatients(), caregiver.getUser_id());
    }

    public static Caregiver toEntity(CaregiverDetailsDTO caregiverDetailsDTO) {
        return new Caregiver(caregiverDetailsDTO.getName(),
        		caregiverDetailsDTO.getBirthdate(),
        		caregiverDetailsDTO.getGender(),
        		caregiverDetailsDTO.getAddress(),
        		caregiverDetailsDTO.getPatients(),
        		caregiverDetailsDTO.getUser_id());
    }
}
