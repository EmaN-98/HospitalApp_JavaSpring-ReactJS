package ro.tuc.ds2020.messages;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.JOptionPane;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ro.tuc.ds2020.entities.Activity;


public class ProcessConsumedMessage {

	public static void process(String msg){
		
		ObjectMapper mapper=new ObjectMapper();
		Activity activity=null;
		try {
			activity = mapper.readValue(msg, Activity.class);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		System.out.println("activityOBJ:"+activity.toString());
		
		switch(activity.getActivity()) {
			case("Sleeping"):
				String result=diffDates(activity);
				String[] splitted=result.split(":");
				for(int i=0;i<splitted.length;i++) {
					System.out.println(i+"-"+splitted[i]);
				}
				int hours=Integer.parseInt(splitted[0]);
				int minutes=Integer.parseInt(splitted[1]);
				int seconds=Integer.parseInt(splitted[2]);
				if(hours>7 || (hours==7 && (minutes>0 || seconds>0))) {
					System.out.println("Something may be wrong: sleeping period is longer than 7 hours!");
				}
				break;
			case("Leaving"):
				result=diffDates(activity);
				splitted=result.split(":");
				for(int i=0;i<splitted.length;i++) {
					System.out.println(i+"-"+splitted[i]);
				}
				hours=Integer.parseInt(splitted[0]);
				minutes=Integer.parseInt(splitted[1]);
				seconds=Integer.parseInt(splitted[2]);
				if(hours>5 || (hours==5 && (minutes>0 || seconds>0))) {
					System.out.println("Something may be wrong: leaving period is longer than 5 hours!");
				}
				break;
			case("Toileting"):	
				result=diffDates(activity);
				splitted=result.split(":");
				for(int i=0;i<splitted.length;i++) {
					System.out.println(i+"-"+splitted[i]);
				}
				hours=Integer.parseInt(splitted[0]);
				minutes=Integer.parseInt(splitted[1]);
				seconds=Integer.parseInt(splitted[2]);
				if(hours>0 || (hours==0 && minutes>30)) {
					System.out.println("Something may be wrong: period spent in bathroom is longer than 30 minutes!");
				}
				break;
			case("Grooming"):	
				result=diffDates(activity);
				splitted=result.split(":");
				for(int i=0;i<splitted.length;i++) {
					System.out.println(i+"-"+splitted[i]);
				}
				hours=Integer.parseInt(splitted[0]);
				minutes=Integer.parseInt(splitted[1]);
				seconds=Integer.parseInt(splitted[2]);
				if(hours>0 || (hours==0 && minutes>30)) {
					System.out.println("Something may be wrong: period spent in bathroom is longer than 30 minutes!");
				}
				break;
			case("Showering"):	
				result=diffDates(activity);
				splitted=result.split(":");
				for(int i=0;i<splitted.length;i++) {
					System.out.println(i+"-"+splitted[i]);
				}
				hours=Integer.parseInt(splitted[0]);
				minutes=Integer.parseInt(splitted[1]);
				seconds=Integer.parseInt(splitted[2]);
				if(hours>0 || (hours==0 && minutes>30)) {
					System.out.println("Something may be wrong: period spent in bathroom is longer than 30 minutes!");
				}
				break;
			default: System.out.println("everything is normal with this activity");
				
		}
		
	}
	
	public static String diffDates(Activity a) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		int diffhours = 0, diffmin = 0, diffsec = 0;
		try {
			long diff = dateFormat.parse(a.getEnd()).getTime() - dateFormat.parse(a.getStart()).getTime();
			diffhours = (int) (diff / (60 * 60 * 1000));
			diffmin = (int) (diff / (60 * 1000)) - (diffhours * 60);
			diffsec = (int) (diff / (1000)) - (diffhours * 3600) - (diffmin * 60);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return diffhours + ":" + diffmin + ":" + diffsec;
	}
}
