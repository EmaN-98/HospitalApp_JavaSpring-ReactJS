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

public class MedicationPlanSDDetailsDTO extends RepresentationModel<MedicationPlanSDDetailsDTO> {
    private UUID id;
    private List<MedicationSD> medication_list;
//    @NotNull
    private String start_med;
//    @NotNull
    private String end_med;
    public MedicationPlanSDDetailsDTO() {
    }
    

	

	public MedicationPlanSDDetailsDTO(List<MedicationSD> medication_list, String start_med, String end_med) {
		super();
		this.medication_list = medication_list;
		this.start_med = start_med;
		this.end_med = end_med;
	}




	public MedicationPlanSDDetailsDTO(UUID id, List<MedicationSD> medication_list, String start_med, String end_med) {
		super();
		this.id = id;
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


	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MedicationPlanSDDetailsDTO medicationPlanSDDetailsDTO = (MedicationPlanSDDetailsDTO) o;
        return medication_list == medicationPlanSDDetailsDTO.medication_list &&
                Objects.equals(start_med, medicationPlanSDDetailsDTO.start_med) &&
                Objects.equals(end_med, medicationPlanSDDetailsDTO.end_med)
        		;
    }

    @Override
    public int hashCode() {
        return Objects.hash(medication_list, start_med, end_med);
    }
}
