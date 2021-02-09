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

public class MedicationPlanSDDTO extends RepresentationModel<MedicationPlanSDDTO> {
    private UUID id;
    private List<MedicationSD> medication_list;
  //  @NotNull
//    private String start_med;
 //   @NotNull
//    private String end_med;
    public MedicationPlanSDDTO() {
    }
    
	
	public MedicationPlanSDDTO(List<MedicationSD> medication_list) {
	super();
	this.medication_list = medication_list;
}


	public MedicationPlanSDDTO(UUID id, List<MedicationSD> medication_list) {
	super();
	this.id = id;
	this.medication_list = medication_list;
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


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationPlanSDDTO medicationPlanSDDTO = (MedicationPlanSDDTO) o;
        return medication_list == medicationPlanSDDTO.medication_list// &&
               // Objects.equals(start_med, medicationPlanSDDTO.start_med) &&
               // Objects.equals(end_med, medicationPlanSDDTO.end_med)
        		;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medication_list/*, start_med, end_med*/);
    }
}
