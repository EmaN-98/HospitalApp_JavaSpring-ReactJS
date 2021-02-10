package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.UserSD;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class CaregiverDetailsDTO extends RepresentationModel<CaregiverDetailsDTO> {
    private UUID id;
   // @NotNull
    private String name;
    //@NotNull
    private String birthdate;
    //@NotNull
    private String gender;
   // @NotNull
    private String address;
  //@NotNull
    private String role;
    private List<Patient> patients;

    private UserSD user_id;

    

   
    public String getRole() {
	return role;
    }

public void setRole(String role) {
	this.role = role;
	}

	
	public CaregiverDetailsDTO(CaregiverDetailsDTO dto) {
		
		this.id = dto.getId();
		this.name = dto.getName();
		this.birthdate = dto.getBirthdate();
		this.gender = dto.getGender();
		this.address = dto.getAddress();
		this.role = dto.getRole();
		//this.patients = dto.getPatients();
		this.user_id = new UserSD(id,name,role);
	}

	public CaregiverDetailsDTO(UUID id, String name, String birthdate, String gender, String address, 
		List<Patient> patients, UserSD user_id,String role) {
	super();
	this.id = id;
	this.name = name;
	this.birthdate = birthdate;
	this.gender = gender;
	this.address = address;
	this.role = role;
	this.patients = patients;
	this.user_id = user_id;
}

	public CaregiverDetailsDTO(UUID id, String name, String birthdate, String gender, String address, String role) {
	super();
	this.id = id;
	this.name = name;
	this.birthdate = birthdate;
	this.gender = gender;
	this.address = address;
	this.role = role;
}

	public CaregiverDetailsDTO(@NotNull String name, @NotNull String birthdate, @NotNull String gender,
			@NotNull String address, List<Patient> patients, @NotNull String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.patients = patients;
		this.role = role;
	}

	public CaregiverDetailsDTO(@NotNull String name, @NotNull String birthdate, @NotNull String gender,
			@NotNull String address, List<Patient> patients, UserSD user_id, @NotNull String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.patients = patients;
		this.user_id = user_id;
		this.role = role;
	}

	

	public CaregiverDetailsDTO(UUID id, @NotNull String name, @NotNull String birthdate, @NotNull String gender,
			@NotNull String address, List<Patient> patients, UserSD user_id) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.patients = patients;
		this.user_id = user_id;
	}





	public CaregiverDetailsDTO() {
		super();
	}

	public CaregiverDetailsDTO(String name, String birthdate, String gender, String address, String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
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

	public List<Patient> getPatients() {
		return patients;
	}

	public void setPatients(List<Patient> patients) {
		this.patients = patients;
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
        CaregiverDetailsDTO caregiverDetailsDTO = (CaregiverDetailsDTO) o;
        return name == caregiverDetailsDTO.name &&
                Objects.equals(birthdate, caregiverDetailsDTO.birthdate) &&
                Objects.equals(gender, caregiverDetailsDTO.gender) &&
                Objects.equals(address, caregiverDetailsDTO.address) &&
                Objects.equals(patients, caregiverDetailsDTO.patients) &&
                Objects.equals(user_id, caregiverDetailsDTO.user_id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, birthdate, gender, address, patients, user_id);
    }
}
