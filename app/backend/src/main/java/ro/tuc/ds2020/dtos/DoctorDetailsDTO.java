package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.UserSD;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class DoctorDetailsDTO extends RepresentationModel<DoctorDetailsDTO> {
    private UUID id;
    @NotNull
   private String name;
   private List<Patient> patients;
   private UserSD user_id;
   @NotNull
   private String role;
   
    public DoctorDetailsDTO() {
    }

    

	



	public DoctorDetailsDTO(UUID id, @NotNull String name, List<Patient> patients, UserSD user_id, String role) {
		super();
		this.id = id;
		this.name = name;
		this.patients = patients;
		this.user_id = user_id;
		this.role = role;
	}







	public DoctorDetailsDTO(@NotNull String name, List<Patient> patients, String role) {
		super();
		this.name = name;
		this.patients = patients;
		this.role = role;
	}







	public DoctorDetailsDTO(@NotNull String name, List<Patient> patients, UserSD user_id, String role) {
		super();
		this.name = name;
		this.patients = patients;
		this.user_id = user_id;
		this.role = role;
	}







	public DoctorDetailsDTO(@NotNull String name, @NotNull String role) {
		super();
		this.name = name;
		this.role = role;
	}







	public DoctorDetailsDTO(UUID id, @NotNull String name, @NotNull String role) {
		super();
		this.id = id;
		this.name = name;
		this.role = role;
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
        DoctorDetailsDTO doctorDetailsDTO = (DoctorDetailsDTO) o;
        return name == doctorDetailsDTO.name &&
                Objects.equals(patients, doctorDetailsDTO.patients) &&
                Objects.equals(user_id, doctorDetailsDTO.user_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, patients, user_id);
    }
}
