package medication;


import java.io.Serializable;
import java.util.ArrayList;

public class Medication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public Medication() {
		super();
	}

	private String medID;
	private String name;
	private ArrayList<String> sideEffects=new ArrayList<String>();
	private String dosage;
	private String intake_interval;
	
	
	public String getMedID() {
		return medID;
	}
	public void setMedID(String medID) {
		this.medID = medID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public ArrayList<String> getSideEffects() {
		return sideEffects;
	}
	public void setSideEffects(ArrayList<String> sideEffects) {
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
	
	public Medication(String medID, String name, ArrayList<String> sideEffects, String dosage, String intake_interval) {
		super();
		this.medID = medID;
		this.name = name;
		this.sideEffects = sideEffects;
		this.dosage = dosage;
		this.intake_interval=intake_interval;
	}
	
	@Override
	public String toString() {
		return "Medication [medID=" + medID + ", name=" + name + ", sideEffects=" + sideEffects + ", dosage=" + dosage + ", intake_interval=" + intake_interval + "]";
	}
	
	
}
