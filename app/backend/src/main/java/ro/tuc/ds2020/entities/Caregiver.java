package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name="caregiver")
public class Caregiver  implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-binary")
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;
    
    @Column(name = "birthdate", nullable = false)
    private String birthdate;
    
    @Column(name = "gender", nullable = false)
    private String gender;
    
    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(cascade=CascadeType.ALL,
    		fetch=FetchType.LAZY,
    		mappedBy="caregiver")
    @Column(name = "patients", nullable = false)
    private List<Patient> patients=new ArrayList<>();

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserSD user_id;

    @Column(name = "role", nullable = false)
    private String role;
    
	public Caregiver() {
	}

	public Caregiver(String name, String birthdate, String gender, String address, List<Patient> patients,
			UserSD user_id) {
		
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.patients = patients;
		this.user_id = user_id;
	}

	

	public Caregiver(String name, String birthdate, String gender, String address, List<Patient> patients,
			String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.patients = patients;
		this.role = role;
	}

	public Caregiver(String name, String birthdate, String gender, String address, List<Patient> patients,
			UserSD user_id, String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.patients = patients;
		this.user_id = user_id;
		this.role = role;
	}
	

	public Caregiver(String name, String birthdate, String gender, String address, String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}

   