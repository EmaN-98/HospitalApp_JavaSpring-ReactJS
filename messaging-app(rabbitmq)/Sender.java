package com.emanuelan.messaging_app;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;


public class Sender {

	private static ArrayList<Activity> activities = new ArrayList<Activity>();
	private static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String args[]) {
		
		String fileNameID="";
		String[] id= {""};
		try {																																								//private final static String findStatementString = "SELECT * FROM product where id_p = ?";
			fileNameID = "keepID.txt";

			FileReader fileReader = 
		            new FileReader(fileNameID);
			BufferedReader bufferedReader =
	                new BufferedReader(fileReader);
			id[0]=bufferedReader.readLine();
			System.out.println("*ID-ul pacientului:"+id[0]+"*");
			bufferedReader.close();
			}
			catch(FileNotFoundException ex) {
				 System.out.println(
			                "Unable to open file '" + 
			                fileNameID + "'");
			} catch (IOException e) {
				e.printStackTrace();
			}
		
		String fileName = "D:\\activity.txt";
		
		try (Stream<String> stream = Files.lines(Paths.get(fileName))) {

			list = (ArrayList<String>) stream.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		for (String s : list) {
			String[] splited = s.split("	");
			activities.add(new Activity(splited[0], splited[2], splited[4]));
		}
		//activities.stream().forEach(System.out::println);
		for(String l:list) System.out.println(l);
		
		ConnectionFactory factory=new ConnectionFactory();
		
		factory.setUri("amqp://...");
		 int[] counter= {0};
		try {
			Connection connection=factory.newConnection();
			Channel channel=connection.createChannel();
			channel.queueDeclare("messagesTema2",false,false,false,null);
				
			Timer t = new Timer();
			t.schedule(new TimerTask() {
			    public void run() {
					try {
						if(counter[0]<activities.size()) {
							String message="{\n\"patient_id\":\""+id[0]+"\",\n"+activities.get(counter[0]).toString()+"\n}";
							channel.basicPublish("", "messagesTema2", false, null, message.getBytes());
							counter[0]++;
							System.out.println("!Message has been sent: "+message);}
					} catch (IOException e) {
						e.printStackTrace();
					}
			    }
			}, 0, 2000);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TimeoutException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
}
