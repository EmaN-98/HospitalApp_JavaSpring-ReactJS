package ro.tuc.ds2020.entities;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="medication")
public class MedicationSD {
	
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(generator = "uuid2")
	    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	    @Type(type = "uuid-binary")
	    private UUID id;

	    @Column(name = "name", nullable = false)
	    private String name;

	    @Column(name = "sideEffects", nullable = false)
	    private String sideEffects;

	    @Column(name = "dosage", nullable = false)
	    private String dosage;
	    
	    @Column(name = "intake_interval", nullable = false)
	    private String intake_interval;

	    @ManyToOne//(targetEntity=Medication.class)
	    @JoinColumn(name="medication")
	    private MedicationSD medication;
	    
		public MedicationSD() {
		}

		public MedicationSD(String name, String sideEffects, String dosage, String intake_interval,
				MedicationSD medication) {
		
			this.name = name;
			this.sideEffects = sideEffects;
			this.dosage = dosage;
			this.intake_interval = intake_interval;
			this.medication = medication;
		}

		/*public Medication( String name,String sideEffects, String dosage, String intake_interval) {
			
			this.name = name;
			this.sideEffects = sideEffects;
			this.dosage = dosage;
			this.intake_interval = intake_interval;
		}*/

		public UUID getId() {
			return id;
		}

		public MedicationSD getMedication() {
			return medication;
		}

		public void setMedication(MedicationSD medication) {
			this.medication = medication;
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

		public String getSideEffects() {
			return sideEffects;
		}

		public void setSideEffects(String sideEffects) {
			this.sideEffects = sideEffects;
		}

		public String getDosage() {
			return dosage;
		}

		public void setDosage(String dosage) {
			this.dosage = dosage;
		}

		public String getIntake_interval() {
			return intake_interval;
		}

		public void setIntake_interval(String intake_interval) {
			this.intake_interval = intake_interval;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	
	
	
}
