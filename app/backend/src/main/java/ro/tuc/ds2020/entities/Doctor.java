package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="doctor")
public class Doctor  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy="doctor")
    @Column(name = "patients", nullable = false)
    private List<Patient> patients;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserSD user_id;

    @Column(name = "role", nullable = false)
    private String role;
    
    public Doctor() {
    }


	public Doctor(String name, String role) {
		super();
		this.name = name;
		this.role = role;
	}


	public Doctor( String name, List<Patient> patients, UserSD user_id) {
		
		this.name = name;
		this.patients = patients;
		this.user_id = user_id;
	}


	public Doctor(String name, List<Patient> patients, String role) {
		super();
		this.name = name;
		this.patients = patients;
		this.role = role;
	}


	public Doctor(String name, List<Patient> patients, UserSD user_id, String role) {
		super();
		this.name = name;
		this.patients = patients;
		this.user_id = user_id;
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}