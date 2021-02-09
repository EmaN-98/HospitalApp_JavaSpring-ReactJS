package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;

import java.util.ArrayList;

import ro.tuc.ds2020.dtos.PatientDTO;
import ro.tuc.ds2020.dtos.PatientDetailsDTO;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.Patient;

public class PatientBuilder {

    private PatientBuilder() {
    }

    public static PatientDTO toPatientDTO(Patient patient) {
        return new PatientDTO(patient.getId(), patient.getName(), patient.getMedical_record(),patient.getCaregiverName());
    }

    public static PatientDetailsDTO toPatientDetailsDTO(Patient patient) {
        return new PatientDetailsDTO(patient.getId(), patient.getName(), patient.getBirthdate(), patient.getGender(), patient.getAddress(),  patient.getMedical_record(),patient.getCaregiverName(),patient.getRole());
    }

    public static Patient toEntity(PatientDetailsDTO patientDetailsDTO) {
        return new Patient(patientDetailsDTO.getName(),
        		patientDetailsDTO.getBirthdate(),
        		patientDetailsDTO.getGender(),
        		patientDetailsDTO.getAddress(),
        		patientDetailsDTO.getMedical_record(),
        		patientDetailsDTO.getCaregiverName(),
        		patientDetailsDTO.getRole());
    }
}
