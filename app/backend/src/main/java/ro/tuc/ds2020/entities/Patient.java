package ro.tuc.ds2020.entities;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;

import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name="patient")
public class Patient  implements Serializable{

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
    
    @Column(name = "medical_record", nullable = false)
    private String medical_record;

    @Column(name = "caregiverName", nullable = false)
    private String caregiverName;
    
    @Column(name = "doctorName", nullable = false)
    private String doctorName;
    
    @ManyToOne
    @JoinColumn(name = "doctor")
    private Doctor doctor;
    
    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name = "caregiver")
    private Caregiver caregiver;
    
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserSD user_id;

    @Column(name = "role", nullable = false)
    private String role;
    
	public Patient() {
	}

	




	public Patient(UUID id, String name, String birthdate, String gender, String address, String medical_record,
			String caregiverName, String doctorName, String role) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.doctorName = doctorName;
		this.role = role;
	}






	public Patient(String name, String birthdate, String gender, String address, String medical_record,
			String caregiverName, String doctorName, Doctor doctor, Caregiver caregiver, UserSD user_id, String role) {
		super();
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.doctorName = doctorName;
		this.doctor = doctor;
		this.caregiver = caregiver;
		this.user_id = user_id;
		this.role = role;
	}






	public Patient(UUID id, String name, String birthdate, String gender, String address, String medical_record,
			String caregiverName, String doctorName, Doctor doctor, Caregiver caregiver, UserSD user_id, String role) {
		super();
		this.id = id;
		this.name = name;
		this.birthdate = birthdate;
		this.gender = gender;
		this.address = address;
		this.medical_record = medical_record;
		this.caregiverName = caregiverName;
		this.doctorName = doctorName;
		this.doctor = doctor;
		this.caregiver = caregiver;
		this.user_id = user_id;
		this.role = role;
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

	public String getMedical_record() {
		return medical_record;
	}

	public void setMedical_record(String medical_record) {
		this.medical_record = medical_record;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public void setDoctor(Doctor doctor) {
		this.doctor = doctor;
	}

	public Caregiver getCaregiver() {
		return caregiver;
	}

	public void setCaregiver(Caregiver caregiver) {
		this.caregiver = caregiver;
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