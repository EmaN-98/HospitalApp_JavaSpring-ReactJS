package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.UserSD;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class PatientDetailsDTO extends RepresentationModel<PatientDetailsDTO> {
    private UUID id;
    @NotNull
    private String name;
    @NotNull
    private String birthdate;
    @NotNull
    private String gender;
    @NotNull
    private String address;
    @NotNull
    private String medical_record;
    private String caregiverName;
    private Doctor doctor;
    private Caregiver caregiver;
    private UserSD user_id;
    @NotNull
    private String role;
   
    public PatientDetailsDTO() {
    }

   


	public PatientDetailsDTO(UUID id, @NotNull String name, @NotNull String birthdate, @NotNull String gender,
			@NotNull String address, @NotNull String medical_record, String caregiverName, @NotNull String role) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.role = role;
	}




	public PatientDetailsDTO(@NotNull String name, @NotNull String birthdate, @NotNull String gender,
			@NotNull String address, @NotNull String medical_record, String caregiverName, Doctor doctor,
			Caregiver caregiver, @NotNull String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.doctor = doctor;
		this.caregiver = caregiver;
		this.role = role;
	}




	public PatientDetailsDTO(@NotNull String name, @NotNull String birthdate, @NotNull String gender,
			@NotNull String address, @NotNull String medical_record, String caregiverName, @NotNull String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.role = role;
	}




	public PatientDetailsDTO(@NotNull String name, @NotNull String birthdate, @NotNull String gender,
			@NotNull String address, @NotNull String medical_record, String caregiverName, Doctor doctor,
			Caregiver caregiver, UserSD user_id, @NotNull String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.doctor = doctor;
		this.caregiver = caregiver;
		this.user_id = user_id;
		this.role = role;
	}




	public PatientDetailsDTO(UUID id, @NotNull String name, @NotNull String birthdate, @NotNull String gender,
			@NotNull String address, @NotNull String medical_record, String caregiverName, Doctor doctor,
			Caregiver caregiver, UserSD user_id, @NotNull String role) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.doctor = doctor;
		this.caregiver = caregiver;
		this.user_id = user_id;
		this.role = role;
	}




	public String getCaregiverName() {
		return caregiverName;
	}




	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
	}




	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}



	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMedical_record() {
		return medical_record;
	}

	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Caregiver getCaregiver() {
		return caregiver;
	}

	public void setCaregiver(Caregiver caregiver) {
		this.caregiver = caregiver;
	}

	public UserSD getUser_id() {
		return user_id;
	}

	public void setUser_id(UserSD user_id) {
		this.user_id = user_id;
	}
    



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDetailsDTO patientDetailsDTO = (PatientDetailsDTO) o;
        return name == patientDetailsDTO.name &&
                Objects.equals(birthdate, patientDetailsDTO.birthdate) &&
                Objects.equals(gender, patientDetailsDTO.gender) &&
                Objects.equals(address, patientDetailsDTO.address) &&
                Objects.equals(medical_record, patientDetailsDTO.medical_record) &&
                Objects.equals(doctor, patientDetailsDTO.doctor) &&
                Objects.equals(caregiver, patientDetailsDTO.caregiver) &&
                Objects.equals(user_id, patientDetailsDTO.user_id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, gender, address, medical_record, doctor, caregiver, user_id);
    }
}
