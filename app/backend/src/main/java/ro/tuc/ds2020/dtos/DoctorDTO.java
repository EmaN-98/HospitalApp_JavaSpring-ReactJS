package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Patient;
import ro.tuc.ds2020.entities.UserSD;

import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class DoctorDTO extends RepresentationModel<DoctorDTO> {
    private UUID id;
   private String name;
   private List<Patient> patients;
  // private UserSD user_id;
   
    public DoctorDTO() {
    }

    

	public DoctorDTO(String name, List<Patient> patients) {
		super();
		this.name = name;
		this.patients = patients;
	}



	public DoctorDTO(UUID id, String name, List<Patient> patients) {
		super();
		this.id = id;
		this.name = name;
		this.patients = patients;
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



	/*public UserSD getUser_id() {
		return user_id;
	}



	public void setUser_id(UserSD user_id) {
		this.user_id = user_id;
	}*/





	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DoctorDTO doctorDTO = (DoctorDTO) o;
        return name == doctorDTO.name &&
                Objects.equals(patients, doctorDTO.patients)// &&
               // Objects.equals(user_id, doctorDTO.user_id)
        		;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, patients/*, user_id*/);
    }
}
