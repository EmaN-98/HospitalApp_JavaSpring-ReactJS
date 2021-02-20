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

public class PatientDTO extends RepresentationModel<PatientDTO> {
    private UUID id;
 //   @NotNull
    private String name;
 //   @NotNull
    private String birthdate;
 //   @NotNull
    private String gender;
  //  @NotNull
    private String address;
 //   @NotNull
    private String medical_record;
    private String caregiverName;
    private String doctorName;
    //private Doctor doctor;
   // private Caregiver caregiver;
//    private UserSD user_id;
   
    public PatientDTO() {
    }

    
    

	public PatientDTO(UUID id, String name, String birthdate, String gender, String address, String medical_record) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
	}




	public PatientDTO(String name, String birthdate, String gender, String address, String medical_record) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
	}




	public PatientDTO(String name, String birthdate, String gender, String address, String medical_record,
			String caregiverName, String doctorName) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.doctorName = doctorName;
	}




	public PatientDTO(UUID id, String name, String birthdate, String gender, String address, String medical_record,
			String caregiverName, String doctorName) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.doctorName = doctorName;
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




	public String getDoctorName() {
		return doctorName;
	}




	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}




	public String getCaregiverName() {
		return caregiverName;
	}


	public void setCaregiverName(String caregiverName) {
		this.caregiverName = caregiverName;
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

/*	public String getBirthdate() {
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
	}*/

	public String getMedical_record() {
		return medical_record;
	}

	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}

//	public Doctor getDoctor() {
//		return doctor;
//	}
//
//	public void setDoctor(Doctor doctor) {
//		this.doctor = doctor;
//	}
//
//	public Caregiver getCaregiver() {
//		return caregiver;
//	}
//
//	public void setCaregiver(Caregiver caregiver) {
//		this.caregiver = caregiver;
//	}

/*	public UserSD getUser_id() {
		return user_id;
	}

	public void setUser_id(UserSD user_id) {
		this.user_id = user_id;
	}*/
    



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PatientDTO patientDTO = (PatientDTO) o;
        return name == patientDTO.name &&
                Objects.equals(birthdate, patientDTO.birthdate) &&
                Objects.equals(gender, patientDTO.gender) &&
                Objects.equals(address, patientDTO.address) &&
                Objects.equals(medical_record, patientDTO.medical_record)// &&
                //Objects.equals(doctor, patientDTO.doctor) &&
               // Objects.equals(caregiver, patientDTO.caregiver)// &&
               // Objects.equals(user_id, patientDTO.user_id)
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name/*, birthdate, gender, address*/, medical_record/*, doctor, caregiver, user_id*/);
    }
}
