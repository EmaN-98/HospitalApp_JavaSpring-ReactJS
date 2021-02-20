package medication;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import gui.GUI;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.SwingUtilities;



public class MedicationBean {

	@Autowired
	private MedicationService medicationService;
	private String medicationPlanString=null;
	MedicationPlan medicationPlan=null;

	public void getMedicationPlan() {
    	
    	long INTERVAL_DELAY = 10000;
    	long INTERVAL_PERIOD = 86400000;
    	
    	Timer timer = new Timer();
    	
    	 timer.scheduleAtFixedRate(new TimerTask() 
    	 {
    	     public void run() 
    	     {
    	    	try {
    	    		medicationPlanString=medicationService.getMedicationPlan("07.01.2020");
    	    		System.out.println("Medication plan in bean:"+medicationPlanString);
					processMedicationPlan(medicationPlanString);
				} catch (IOException e) {
					e.printStackTrace();
				}
     	    	System.out.println("~medicationPlan in client:"+medicationPlanString+"~");
     	   

    	     }

    	 }, INTERVAL_DELAY, INTERVAL_PERIOD);

    }
	
	 void processMedicationPlan(String medicationPlanString) throws IOException {
		 ObjectMapper mapper=new ObjectMapper();
			
			try {
				medicationPlan = mapper.readValue(medicationPlanString, MedicationPlan.class);
				System.out.println("\nmedicationPlanOBJ....:"+medicationPlanString);
			} catch (JsonProcessingException e) {
				e.printStackTrace();
			}
			System.out.println("\nmedicationPlanOBJ:"+medicationPlan.toString());
			SwingUtilities.invokeLater(new Runnable() {
	             @Override
	             public void run() {
	                 new GUI(medicationPlan,medicationService);
	             }
	         });
			
	 }
	 
	 public void notifyTakenMed(String m) {
		 medicationService.notifyTakenMed(m);
	 }
}