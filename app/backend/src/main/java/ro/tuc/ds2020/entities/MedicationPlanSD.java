package ro.tuc.ds2020.entities;

import java.util.List;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;


import javax.persistence.*;
import javax.persistence.Entity;

@Entity
@Table(name="medicationplan")
public class MedicationPlanSD {
	
	 private static final long serialVersionUID = 1L;

	    @Id
	    @GeneratedValue(generator = "uuid2")
	    @GenericGenerator(name = "uuid2", strategy = "uuid2")
	    @Type(type = "uuid-binary")
	    private UUID id;
	    
	    @OneToMany(mappedBy="medication")
	    @Column(name = "medication_list", nullable = false)
	    private List<MedicationSD> medication_list;

	    @Column(name = "start_med", nullable = false)
	    private String start_med;
	    
	    @Column(name = "end_med", nullable = false)
	    private String end_med;

		public MedicationPlanSD() {
		}

		public MedicationPlanSD( List<MedicationSD> medication_list, String start_med, String end_med) {
			
			this.medication_list = medication_list;
			this.start_med = start_med;
			this.end_med = end_med;
		}

		public UUID getId() {
			return id;
		}

		public void setId(UUID id) {
			this.id = id;
		}

		public List<MedicationSD> getMedication_list() {
			return medication_list;
		}

		public void setMedication_list(List<MedicationSD> medication_list) {
			this.medication_list = medication_list;
		}

		public String getStart_med() {
			return start_med;
		}

		public void setStart_med(String start_med) {
			this.start_med = start_med;
		}

		public String getEnd_med() {
			return end_med;
		}

		public void setEnd_med(String end_med) {
			this.end_med = end_med;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}
	    
		
	    
	
}
