package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.UserSD;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class CaregiverDTO extends RepresentationModel<CaregiverDTO> {
    private UUID id;
   // @NotNull
    private String name;
   // @NotNull
//    private String birthdate;
  //  @NotNull
//    private String gender;
  //  @NotNull
//    private String address;
   // @NotNull
    private List<Patient> patients;
   // @NotNull
//    private UserSD user_id;
   
    public CaregiverDTO() {
    }

	public CaregiverDTO(UUID id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public CaregiverDTO(UUID id, String name, List<Patient> patients) {
		super();
		this.id = id;
		this.name = name;
		this.patients = (List<Patient>) patients;
	}

	public CaregiverDTO(String name/*, String birthdate, String gender, String address*/, List<Patient> patients/*,
			UserSD user_id*/) {
		super();
		this.name = name;
		//this.birthdate = birthdate;
		//this.gender = gender;
		//this.address = address;
		this.patients = patients;
	//	this.user_id = user_id;
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

	/*public String getBirthdate() {
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
	}

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
        CaregiverDTO caregiverDTO = (CaregiverDTO) o;
        return name == caregiverDTO.name &&
                //Objects.equals(birthdate, caregiverDTO.birthdate) &&
               // Objects.equals(gender, caregiverDTO.gender) &&
              //  Objects.equals(address, caregiverDTO.address) &&
                Objects.equals(patients, caregiverDTO.patients)// &&
              //  Objects.equals(user_id, caregiverDTO.user_id) 
                ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, /*birthdate, gender, address,*/ patients/*, user_id*/);
    }

}
