package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import java.util.Objects;
import java.util.UUID;

public class UserSDDetailsDTO extends RepresentationModel<UserSDDetailsDTO> {
    private UUID id;
    private String username;
    private String password;
    private String role;
    
    public UserSDDetailsDTO() {
    }

    

    public UserSDDetailsDTO(String username, String password, String role) {
		super();
		this.username = username;
		this.password = password;
		this.role = role;
	}



	public UserSDDetailsDTO(UUID id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
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



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
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
        UserSDDetailsDTO userSDDetailsDTO = (UserSDDetailsDTO) o;
        return username == userSDDetailsDTO.username &&
                Objects.equals(password, userSDDetailsDTO.password) &&
                Objects.equals(role, userSDDetailsDTO.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(username,password,role);
    }
}
