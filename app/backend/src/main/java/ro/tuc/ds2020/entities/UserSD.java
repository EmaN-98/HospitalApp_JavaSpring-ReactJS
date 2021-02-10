package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="userSD")
public class UserSD  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "username", nullable = false)
    private String username;
    
    @Column(name = "password", nullable = false)
    private String password;
    
    @Column(name = "role", nullable = false)
    private String role;


    @OneToOne(mappedBy="user_id")
    private Doctor doctor;

    @OneToOne(mappedBy="user_id")
    private Caregiver caregiver;
    
	public UserSD() {
	}

	public UserSD(String username, String password, String role) {
		
		this.username = username;
		this.password = password;
		this.role = role;
	}

	public UserSD(UUID id, String username, String password, String role, Doctor doctor, Caregiver caregiver) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.doctor = doctor;
		this.caregiver = caregiver;
	}

	public UserSD(UUID id, String username, String password, String role) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
	}
	
	

	public UserSD(UUID id, String username, String role) {
		super();
		this.id = id;
		this.username = username;
		this.role = role;
	}

	public UserSD(String password, String role) {
		super();
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

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
    
}

