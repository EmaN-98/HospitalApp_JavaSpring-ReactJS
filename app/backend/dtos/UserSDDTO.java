package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;

public class UserSDDTO extends RepresentationModel<UserSDDetailsDTO> {
    private UUID id;
    private String username;
    private String role;
    
    public UserSDDTO() {
    }

    

    public UserSDDTO(UUID id,String username,  String role) {
		super();
		this.id=id;
		this.username = username;
		this.role = role;
	}



	public UserSDDTO(String username, String role) {
		super();
		this.username = username;
		this.role = role;
	}



	public UUID getId() {
		return id;
	}



	public void setId(UUID id) {
		this.id = id;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	


	public String getRole() {
		return role;
	}



	public void setRole(String role) {
		this.role = role;
	}



	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserSDDTO userSDDTO = (UserSDDTO) o;
        return username == userSDDTO.username &&
                Objects.equals(role, userSDDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,role);
    }
}
