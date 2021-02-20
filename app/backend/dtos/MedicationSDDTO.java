package ro.tuc.ds2020.dtos;

import org.springframework.hateoas.RepresentationModel;

import ro.tuc.ds2020.entities.Caregiver;
import ro.tuc.ds2020.entities.Doctor;
import ro.tuc.ds2020.entities.MedicationSD;
import ro.tuc.ds2020.entities.UserSD;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import javax.validation.constraints.NotNull;

public class MedicationSDDTO extends RepresentationModel<MedicationSDDTO> {
    private UUID id;
   // @NotNull
    private String name;
   // @NotNull
    private String sideEffects;
   // @NotNull
    private String dosage;
   // @NotNull
    private String intake_interval;
   // private MedicationSD medication;
   
    public MedicationSDDTO() {
    }
    
  

	public MedicationSDDTO(String name, String sideEffects, String dosage, String intake_interval) {
	super();
	this.name = name;
	this.sideEffects = sideEffects;
	this.dosage = dosage;
	this.intake_interval = intake_interval;
}



	public MedicationSDDTO(UUID id, String name, String sideEffects, String dosage, String intake_interval) {
		super();
		this.id = id;
		this.name = name;
		this.sideEffects = sideEffects;
		this.dosage = dosage;
		this.intake_interval = intake_interval;
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




	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationSDDTO medicationSDDTO = (MedicationSDDTO) o;
        return name == medicationSDDTO.name &&
                Objects.equals(sideEffects, medicationSDDTO.sideEffects) &&
                Objects.equals(dosage, medicationSDDTO.dosage) &&
                Objects.equals(intake_interval, medicationSDDTO.intake_interval) 
              ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sideEffects, dosage, intake_interval);
    }
}
