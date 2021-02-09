package ro.tuc.ds2020.medication;

import java.util.ArrayList;

public class MedicationPlan {

	private ArrayList<Medication> med_list = new ArrayList<Medication>();
	private String start_med;
	private String end_med;
	
	public MedicationPlan(ArrayList<Medication> med_list, String intake_interval, String start_med, String end_med) {
		super();
		this.med_list = med_list;
		this.start_med = start_med;
		this.end_med = end_med;
	}

	public ArrayList<Medication> getMed_list() {
		return med_list;
	}

	public void setMed_list(ArrayList<Medication> med_list) {
		this.med_list = med_list;
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
	public String toString() {
		return "MedicationPlan [med_list=" + med_list + ", start_med="
				+ start_med + ", end_med=" + end_med + "]";
	}
	
	
}
