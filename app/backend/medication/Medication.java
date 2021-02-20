package ro.tuc.ds2020.medication;

import java.io.Serializable;
import java.util.ArrayList;

public class Medication implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String ID;
	private String name;
	private ArrayList<String> sideEffects=new ArrayList<String>();
	private String dosage;
	private String intake_interval;
	
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
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
	
	public Medication(String iD, String name, ArrayList<String> sideEffects, String dosage, String intake_interval) {
		super();
		ID = iD;
		this.name = name;
		this.sideEffects = sideEffects;
		this.dosage = dosage;
		this.intake_interval=intake_interval;
	}
	
	@Override
	public String toString() {
		return "Medication [ID=" + ID + ", name=" + name + ", sideEffects=" + sideEffects + ", dosage=" + dosage + ", intake_interval=" + intake_interval + "]";
	}
	
	
}
