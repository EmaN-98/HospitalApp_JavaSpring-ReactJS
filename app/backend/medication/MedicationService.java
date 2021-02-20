package ro.tuc.ds2020.medication;


	public interface MedicationService {

	    String getMedicationPlan(String date);

	    void notifyTakenMed(String m);
	
	    void notifyNOTTakenMed(String m);
	}
