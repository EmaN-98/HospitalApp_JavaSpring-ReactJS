package ro.tuc.ds2020.medication;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
public class MedicationServiceImpl implements MedicationService {
   
	@Override
	public String getMedicationPlan(String date) {
		String file="src//main//resources//med.txt";
		String med=null;
		try {							

			FileReader fileReader = 
		            new FileReader(file);
			BufferedReader bufferedReader =
	                new BufferedReader(fileReader);
			med=bufferedReader.readLine();
			System.out.println("*medicationPlan in server:"+med+"*");
			bufferedReader.close();
			}
			catch(FileNotFoundException ex) {
				 System.out.println(
			                "Unable to open file '" + 
			                		file + "'");
			} catch (IOException e) {
				e.printStackTrace();
			}
		return med;
	}

	@Override
	public void notifyTakenMed(String m) {
		System.out.println("Patient just took medication - '"+ m +"' - on time");
		
	}

	@Override
	public void notifyNOTTakenMed(String m) {
		System.out.println("Patient did NOT take medication - '"+ m +"' - on time");
	}
}