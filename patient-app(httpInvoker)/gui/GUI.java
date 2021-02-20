package gui;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;

import medication.Medication;
import medication.MedicationPlan;
import medication.MedicationService;
public class GUI extends JFrame
{
	 
    private JLabel clockLbl;
    public final static int ONE_SECOND = 1000;
    private final SimpleDateFormat clockFormat = new SimpleDateFormat("HH:mm:ss");
    int selectedRowIndex=0;
    String takenMedID="";
    String takenMedName="";
    String intakeInterval="";
    private static MedicationService service;

    
    public GUI(MedicationPlan plan,MedicationService srv)
    {
    	service=srv;
    	
    	System.out.println("medication plan in gui:"+plan.toString());
        String[] columns = new String[] {
            "MedID", "Name", "Side Effects", "Dosage", "Intake Interval","Taken"
        };
         
        Object[][] data=new String[10][6]; int i=0;
        for (Medication med : plan.getMed_list()) {
        	
        	System.out.println(i+"--"+med.getMedID().toString());
        	data[i][0]=med.getMedID();
        	data[i][1]=med.getName();
        	data[i][2]=med.getSideEffects().toString();
        	data[i][3]=med.getDosage();
        	data[i][4]=med.getIntake_interval();
        	data[i][5]="Not taken yet";
        	
        	i++;
        }
        
        
        
        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);
        JLabel lbl = null;
        lbl=new JLabel(new ImageIcon("D:\\pillss.jpg"));
		this.add(lbl);
		lbl.setLayout(new FlowLayout());
        lbl.add(new JScrollPane(table));
        
       
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectedRowIndex = table.getSelectedRow();
                takenMedID=(String)data[selectedRowIndex][0];
                takenMedName=(String)data[selectedRowIndex][1];
                intakeInterval=(String)data[selectedRowIndex][4];
            }
        });
        
        JButton taken=new JButton("Taken");
        lbl.add(taken);
        taken.addActionListener(new ActionListener() {
        	 @Override
         	public void actionPerformed(ActionEvent arg0) {
        		 String[] splitted = intakeInterval.split("-");
        		 System.out.println("date "+clockFormat.format(new Date()));
        		 String[] splitted2=clockFormat.format(new Date()).split(":");
        		 System.out.println("hour "+splitted2[0]);
        		 if(Integer.parseInt(splitted[0])<=Integer.parseInt(splitted2[0]) && Integer.parseInt(splitted[1])>Integer.parseInt(splitted2[0])) {
        			 DefaultTableModel model = (DefaultTableModel)table.getModel();
        			 model.setValueAt("Taken", selectedRowIndex, 5);
        			 service.notifyTakenMed(takenMedName);
        		}
         	}
        });
       
      /*  for(int x=0;x<i;x++) {
        	String interval=(String)data[x][4];
        	String[] splitted = interval.split("-");
        	String[] splitted2=clockFormat.format(new Date()).split(":");
        	if(Integer.parseInt(splitted[1])<=Integer.parseInt(splitted2[0]) && (String)data[x][5]=="Not taken yet") {
        		model.setValueAt("NOT TAKEN ON TIME!", x, 5);
        		service.notifyNOTTakenMed((String)data[x][1]);
        	}
        }*/
        
      
    	
        
        clockLbl = new JLabel();
        clockLbl.setFont(new Font(clockLbl.getFont().getName(), Font.PLAIN, 75));
        clockLbl.setForeground(Color.CYAN);
        lbl.add(clockLbl);
        Timer timer = new Timer(ONE_SECOND, new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				 clockLbl.setText(clockFormat.format(new Date()));
	                clockLbl.repaint();
	                
	                
	                //Object[][] data=new String[10][6]; 
	                int nrRows=0;
	                for (Medication med : plan.getMed_list()) {
	                	
	                	nrRows++;
	                }
	                System.out.println("nrRows:"+nrRows);
	                
	                String[] splitted2=clockFormat.format(new Date()).split(":");
	            	int currentHour=Integer.parseInt(splitted2[0]); System.out.println("currentHour: "+currentHour);
	            	int currentMinute=Integer.parseInt(splitted2[1]); System.out.println("currentMinute: "+currentMinute);
	            	String currentSecondsStr=new Date().toString().substring(17, 19); 
	            	int currentSeconds=Integer.parseInt(currentSecondsStr);System.out.println("currentSeconds: "+currentSeconds);
	            	if(currentMinute==0 && currentSeconds==0) {
	            		 for(int x=0;x<nrRows;x++) {
	            	        	String interval=(String)data[x][4]; System.out.println("interval:"+interval); 
	            	        	String[] splitted = interval.split("-"); System.out.println("splitted:"+splitted);
	            	        	int intake=Integer.parseInt(splitted[1]);
	            	        	if((String)data[x][5]=="Not taken yet" && currentHour==intake) {
	            	        		model.setValueAt("NOT TAKEN ON TIME!", x, 5);
	            	        		service.notifyNOTTakenMed((String)data[x][1]);
	            	        	}
	            	}}
			}
        });
        clockLbl.setText(clockFormat.format(new Date()));
        timer.start();
        
        this.setTitle("Pill dispenser");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);     
        
        this.pack();
        this.setVisible(true);
    }

	
     
  
}