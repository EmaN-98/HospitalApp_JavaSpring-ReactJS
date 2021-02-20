package ro.tuc.ds2020.dtos.builders;

import ro.tuc.ds2020.dtos.PersonDTO;
import ro.tuc.ds2020.dtos.PersonDetailsDTO;
import ro.tuc.ds2020.dtos.DoctorDTO;
import ro.tuc.ds2020.dtos.DoctorDetailsDTO;
import ro.tuc.ds2020.entities.Person;
import ro.tuc.ds2020.entities.Doctor;

public class DoctorBuilder {

    private DoctorBuilder() {
    }

    public static DoctorDTO toDoctorDTO(Doctor doctor) {
        return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getPatients());
    }

    public static DoctorDetailsDTO toDoctorDetailsDTO(Doctor doctor) {
        return new DoctorDetailsDTO(doctor.getId(), doctor.getName(), doctor.getPatients(), doctor.getUser_id(),doctor.getRole());
    }

    public static Doctor toEntity(DoctorDetailsDTO doctorDetailsDTO) {
        return new Doctor(doctorDetailsDTO.getName(),
        		doctorDetailsDTO.getPatients(),
        		doctorDetailsDTO.getUser_id());
    }
}
