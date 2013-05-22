package org.menu_builder;

import java.awt.Color;
import java.awt.GraphicsEnvironment;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.concurrent.TimeUnit;
import xml_parser.*;

import javax.swing.*;

import org.mugsandcoffee.CreateFacilities;
import org.mugsandcoffee.CreateNetwork;
import org.mugsandcoffee.CreateOutput;
import org.mugsandcoffee.CreatePopulation;
import xml_parser.file_handler;
import com.mysql.jdbc.Statement;
import org.mugsandcoffee.datasource.*;

public class mainMenu {
	
	private static LayoutBuilder layout;

	public static void main(String[] args) {
		layout = new LayoutBuilder( 270, 800, "Agent-Based Simulation Model");
		
		Font font = new Font("Lucida Sans Unicode, Lucida Grande, sans-serif", Font.BOLD, 17);
		Color color= null;
		color = color.darkGray;
		
		JLabel lbl = layout.buildJLabel("ERS for DRVs", font, 120, 15, color, ((layout.scrnwidth/4) - (120/8)), 10);
		layout.addbuilder(lbl);
		
		JButton btn = layout.buildJButton("Create Network", 160, 30, 40, 50);
		layout.addbuilder(btn);
		
		btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 
        		/* Create network.xml */
            	CreateNetwork network = new CreateNetwork();
            	network.generateNetwork();
            	
            	JOptionPane.showMessageDialog(null, "Successfully Created network.xml");
            	
            }
        });
		
		//buttons
		JButton btn2 = layout.buildJButton("Create Facilities", 160, 30, 210, 50);
		layout.addbuilder(btn2);
		
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 
        		/* Create facilities.xml */
            	CreateFacilities facilities = new CreateFacilities();
            	facilities.generateFacilities();
            	
            	JOptionPane.showMessageDialog(null, "Successfully Created facilities.xml");
            	
            }
        });
		
		JButton btn3 = layout.buildJButton("Create DRVs", 160, 30, 40,  90);
		layout.addbuilder(btn3);
		
		btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	new CreatePopulation();
            	
            	JOptionPane.showMessageDialog(null, "Successfully Created population.xml");
            }
        });
		
		JButton btn4 = layout.buildJButton("Create Output", 160, 30, 210, 90);
		layout.addbuilder(btn4);
		
		btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	
        		/* Create output files */
        		CreateOutput output = new CreateOutput();
        		output.generateOutput(); 
        		
        		JOptionPane.showMessageDialog(null, "Successfully Created Output Folder");
            	
            }
        });
		
		JButton btn5 = layout.buildJButton("Add road closure", 160, 30, 40, 130);
		layout.addbuilder(btn5);
		
		btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	String numRoad = JOptionPane.showInputDialog("Enter how many Road Closure you want");
            	int totalCount = Integer.parseInt(numRoad);

            	String facility = null;
            	facility = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n";
            	facility = facility + "<networkChangeEvents xmlns=\"http://www.matsim.org/files/dtd\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xsi:schemaLocation=\"http://www.matsim.org/files/dtd http://www.matsim.org/files/dtd/networkChangeEvents.xsd\">\n";
            	int checker = 0;
            	for(int i=0; i<totalCount;i++){
            		
            		
            		
            		
            		DefaultComboBoxModel timeget = new DefaultComboBoxModel();
            		timeget.addElement("00:00:00");
            		timeget.addElement("01:00:00");
            		timeget.addElement("02:00:00");
            		timeget.addElement("03:00:00");
            		timeget.addElement("04:00:00");
            		timeget.addElement("05:00:00");
            		timeget.addElement("06:00:00");
            		timeget.addElement("07:00:00");
            		timeget.addElement("08:00:00");
            		timeget.addElement("09:00:00");
            		timeget.addElement("10:00:00");
            		timeget.addElement("11:00:00");
            		timeget.addElement("12:00:00");
            		timeget.addElement("13:00:00");
            		timeget.addElement("14:00:00");
            		timeget.addElement("15:00:00");
            		timeget.addElement("16:00:00");
            		timeget.addElement("17:00:00");
            		timeget.addElement("18:00:00");
            		timeget.addElement("19:00:00");
            		timeget.addElement("20:00:00");
            		timeget.addElement("21:00:00");
            		timeget.addElement("22:00:00");
            		timeget.addElement("23:00:00");
            		timeget.addElement("24:00:00");
            		
                    JComboBox comboBox = new JComboBox(timeget);
            		
            		
            		JTextField Id = new JTextField();
            		
            		
            		
            		JTextField Id2 = new JTextField();
            		
            		Object[] message = {
            			"Road Closure",
            			"Enter Link's and Time of the Road",
            			"Time : ", comboBox,
            		    "Link Id : ", Id,
            		    "Second Link",
            		    "Link Id : ", Id2
            		};

            		int option = JOptionPane.showConfirmDialog(null, message, "Road Closure", JOptionPane.OK_CANCEL_OPTION);
            		if (option == JOptionPane.OK_OPTION) {
            			
            			facility = facility + "\n\t<networkChangeEvent startTime=\""+ timeget.getSelectedItem() +"\">\n";
                		facility = facility + "\t\t<link refId=\""+ Id.getText() +"\"/>\n";
                		facility = facility + "\t\t<freespeed type=\"absolute\" value=\"0.0\"/>\n";
                		facility = facility + "\t</networkChangeEvent>\n\n";
            			
            			facility = facility + "\n\t<networkChangeEvent startTime=\""+ timeget.getSelectedItem() +"\">\n";
                		facility = facility + "\t\t<link refId=\""+ Id2.getText() +"\"/>\n";
                		facility = facility + "\t\t<freespeed type=\"absolute\" value=\"0.0\"/>\n";
                		facility = facility + "\t</networkChangeEvent>\n\n";
        
            		} else {
            			checker = 1;
            			break;
            		    
            		}
            		//
            		
            		
            	}
            	
            	if(checker == 0){
	            	facility = facility + "</networkChangeEvents>";
	            	file_handler file2 = new file_handler( "input/roadClosure.xml" );
	        		file2.create_file( facility );
	        		JOptionPane.showMessageDialog( null, "roadClosure.xml created!");
            	}else{
            		System.out.println("Road closure cancelled");
            	}
        		
            }
        });
		
		//buttons
		JButton btn6 = layout.buildJButton("Add Vehicle", 160, 30, 210, 130);
		layout.addbuilder(btn6);
		
		btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	String numvehicles = JOptionPane.showInputDialog("Please input Total No. of Vehicles");
            	int numvec = Integer.parseInt(numvehicles);
            	String pop = createAddedPopulation(numvec);
            	file_handler file2 = new file_handler( "input/NewPopulation.xml" );
        		file2.create_file( pop );
        		JOptionPane.showMessageDialog( null, "NewPopulation.xml created");
            }
        });
		
		JButton btn7 = layout.buildJButton("Search", 160, 30, 40, 170);
		layout.addbuilder(btn7);
		
		
		
		btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	String street_name = JOptionPane.showInputDialog("Search name of St.");
            	String street = search_street(street_name);
            	Font font = new Font("Arial", Font.BOLD, 13);
            	JTextArea textArea = new JTextArea();
            	textArea.setFont(font);
            	textArea.setText(" Link Id's : \n\n" +street);
            	textArea.setSize(300, Short.MAX_VALUE); // limit = width in pixels, e.g. 500
            	textArea.setWrapStyleWord(true);
            	textArea.setRows(10);
            	textArea.setLineWrap(true);
            	
            	JOptionPane.showMessageDialog( null, textArea, "Link id's of "+ street_name, JOptionPane.WARNING_MESSAGE);
            }
        });
		
		JButton btnEventLogReports = layout.buildJButton("Event Log Reports",  160, 30, 210, 170);
		layout.addbuilder(btnEventLogReports);
		
		btnEventLogReports.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
//				JOptionPane.showMessageDialog( null, textArea, "Link id's of "+ street_name, JOptionPane.WARNING_MESSAGE);
				//System.out.println("Call the event log button");
				mncTable tb = new mncTable();
				
				try {
//					String strQry = "SELECT p.name, r.links, r.distance, r.timefrom, r.timeto, r.timeelapsed, r.direction FROM route r LEFT JOIN person p ON r.agent=p.idw";
					String strQry = "SELECT l.id, l.origid, s.street_name FROM street_info s LEFT JOIN links l ON s.link_id=l.origid WHERE l.id IS NOT NULL";
					String[] tblHeader = {"Matsim ID", "OpenStreet Map ID", "Street Name"};//{"Agent Name", "Links", "Distance", "From", "To", "Elapse Time", "Direcion"};
					tb.showTable(strQry, tblHeader, "Street Information");
					
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
	}
	
	private static String createAddedPopulation(int numvehicle){
		String population = "";
		

		for(int i=0; i<numvehicle; i++){
			
			int choice = 0 + (int)(Math.random()*3);
			
			if(choice==0){
				int min = 1 + (int)(Math.random()*59);
				int hr = 7 + (int)(Math.random()*(11-7));
				long millis = ((1000) * (60) * (60*hr)) - ((1000*60) * min );
				
			    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
			            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
			            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
			   
			    	System.out.println("1 7-9:" +hms);
			    
			    int min2 = 1 + (int)(Math.random()*59);
				int hr2 = 7 + (int)(Math.random()*(11-7));
				long millis2 = ((1000) * (60) * (60*hr2)) - ((1000*60) * min2 );
				String hms2 = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis2),
			            TimeUnit.MILLISECONDS.toMinutes(millis2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis2)),
			            TimeUnit.MILLISECONDS.toSeconds(millis2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis2)));
			   
				while( millis2 < millis ){

			    		min2 = 1 + (int)(Math.random()*59);
						hr2 = 7 + (int)(Math.random()*(11-7));
						millis2 = ((1000) * (60) * (60*hr2)) - ((1000*60) * min2 );
						hms2 = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis2),
					            TimeUnit.MILLISECONDS.toMinutes(millis2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis2)),
					            TimeUnit.MILLISECONDS.toSeconds(millis2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis2)));

			    		
				}
				
				System.out.println("2 7-9:" +hms2);
				
				
				population = population + "<!-- =============================== random" + i +" ======================================= -->\n\n";

        		population = population + "\t\t<person id=\""+ (45+i) +"\" employed=\"yes\">\n";
        				population = population + "\t\t\t<plan selected=\"yes\">\n";
													        				String parsed_text = selectEvent();
													        				String[] result;
													        				result = parsed_text.split(",");
        					population = population + "\t\t\t\t<act type=\"origin\" x=\""+ result[0] +"\" y=\""+ result[1] +"\"  end_time=\""+ hms +"\" />\n";
        					population = population + "\t\t\t\t\t<leg mode=\"car\" dep_time=\""+ hms  +"\">\n";
        					population = population + "\t\t\t\t\t</leg>\n";
												        					String parsed_text2 = selectEvent();
													        				String[] result2;
													        				result2 = parsed_text2.split(",");
        					population = population + "\t\t\t\t<act type=\"destination\" facility=\"19\" x=\""+ result2[0] +"\" y=\""+ result2[1] +"\" end_time=\""+ hms2 +"\" />\n";
        					population = population + "\t\t\t\t\t<leg mode=\"car\" dep_time=\""+ hms2 +"\">\n";
        					population = population + "\t\t\t\t\t</leg>\n";
        					population = population + "\t\t\t\t<act type=\"origin\" x=\""+ result[0] +"\" y=\""+ result[1] +"\" />\n";
        				population = population + "\t\t\t</plan>\n";

        		population = population + "\t\t</person>\n\n";
        	
        		population = population + "\n\n";
        		
			}else if (choice==1) {
			    	
			    	int min = 1 + (int)(Math.random()*59);
					int hr = 13 + (int)(Math.random()*(18-13));
					long millis = ((1000) * (60) * (60*hr)) - ((1000*60) * min );
					
				    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
				            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
				            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
				   
				    	System.out.println("1 13-17:" +hms);
				    
				    int min2 = 1 + (int)(Math.random()*59);
					int hr2 = 13 + (int)(Math.random()*(18-13));
					long millis2 = ((1000) * (60) * (60*hr2)) - ((1000*60) * min2 );
					String hms2 = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis2),
				            TimeUnit.MILLISECONDS.toMinutes(millis2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis2)),
				            TimeUnit.MILLISECONDS.toSeconds(millis2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis2)));
				   
					while( millis2 < millis ){

				    		min2 = 1 + (int)(Math.random()*59);
							hr2 = 13 + (int)(Math.random()*(18-13));
							millis2 = ((1000) * (60) * (60*hr2)) - ((1000*60) * min2 );
							hms2 = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis2),
						            TimeUnit.MILLISECONDS.toMinutes(millis2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis2)),
						            TimeUnit.MILLISECONDS.toSeconds(millis2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis2)));

				    		
					}
				
				
					System.out.println("2 13-17:" +hms2);
					population = population + "<!-- =============================== random" + i +" ======================================= -->\n\n";

	        		population = population + "\t\t<person id=\""+ (45+i) +"\" employed=\"yes\">\n";
	        				population = population + "\t\t\t<plan selected=\"yes\">\n";
														        				String parsed_text = selectEvent();
														        				String[] result;
														        				result = parsed_text.split(",");
	        					population = population + "\t\t\t\t<act type=\"origin\"  x=\""+ result[0] +"\" y=\""+ result[1] +"\"  end_time=\""+ hms +"\" />\n";
	        					population = population + "\t\t\t\t\t<leg mode=\"car\" dep_time=\""+ hms  +"\">\n";
	        					population = population + "\t\t\t\t\t</leg>\n";
													        					String parsed_text2 = selectEvent();
														        				String[] result2;
														        				result2 = parsed_text2.split(",");
	        					population = population + "\t\t\t\t<act type=\"destination\"  x=\""+ result2[0] +"\" y=\""+ result2[1] +"\" end_time=\""+ hms2 +"\" />\n";
	        					population = population + "\t\t\t\t\t<leg mode=\"car\" dep_time=\""+ hms2 +"\">\n";
	        					population = population + "\t\t\t\t\t</leg>\n";
	        					population = population + "\t\t\t\t<act type=\"origin\"  x=\""+ result[0] +"\" y=\""+ result[1] +"\" />\n";
	        				population = population + "\t\t\t</plan>\n";

	        		population = population + "\t\t</person>\n\n";
	        	
	        		population = population + "\n\n";
			}else{
				
			    	int min = 1 + (int)(Math.random()*59);
					int hr = 17 + (int)(Math.random()*(24-17));
					long millis = ((1000) * (60) * (60*hr)) - ((1000*60) * min );
					
				    String hms = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis),
				            TimeUnit.MILLISECONDS.toMinutes(millis) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis)),
				            TimeUnit.MILLISECONDS.toSeconds(millis) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis)));
				   
				    	System.out.println("1 17-24:" +hms);
				    
				    int min2 = 1 + (int)(Math.random()*59);
					int hr2 = 17 + (int)(Math.random()*(24-17));
					long millis2 = ((1000) * (60) * (60*hr2)) - ((1000*60) * min2 );
					String hms2 = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis2),
				            TimeUnit.MILLISECONDS.toMinutes(millis2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis2)),
				            TimeUnit.MILLISECONDS.toSeconds(millis2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis2)));
				   
					while( millis2 < millis ){

				    		min2 = 1 + (int)(Math.random()*59);
							hr2 = 17 + (int)(Math.random()*(24-17));
							millis2 = ((1000) * (60) * (60*hr2)) - ((1000*60) * min2 );
							hms2 = String.format("%02d:%02d:%02d", TimeUnit.MILLISECONDS.toHours(millis2),
						            TimeUnit.MILLISECONDS.toMinutes(millis2) - TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(millis2)),
						            TimeUnit.MILLISECONDS.toSeconds(millis2) - TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(millis2)));

				    		
					}
					
					System.out.println("2  17-24:" +hms2);
					population = population + "<!-- =============================== random" + i +" ======================================= -->\n\n";

	        		population = population + "\t\t<person id=\""+ (45+i) +"\" employed=\"yes\">\n";
	        				population = population + "\t\t\t<plan selected=\"yes\">\n";
														        				String parsed_text = selectEvent();
														        				String[] result;
														        				result = parsed_text.split(",");
	        					population = population + "\t\t\t\t<act type=\"origin\" x=\""+ result[0] +"\" y=\""+ result[1] +"\"  end_time=\""+ hms +"\" />\n";
	        					population = population + "\t\t\t\t\t<leg mode=\"car\" dep_time=\""+ hms  +"\">\n";
	        					population = population + "\t\t\t\t\t</leg>\n";
													        					String parsed_text2 = selectEvent();
														        				String[] result2;
														        				result2 = parsed_text2.split(",");
	        					population = population + "\t\t\t\t<act type=\"destination\"  x=\""+ result2[0] +"\" y=\""+ result2[1] +"\" end_time=\""+ hms2 +"\" />\n";
	        					population = population + "\t\t\t\t\t<leg mode=\"car\" dep_time=\""+ hms2 +"\">\n";
	        					population = population + "\t\t\t\t\t</leg>\n";
	        					population = population + "\t\t\t\t<act type=\"origin\" x=\""+ result[0] +"\" y=\""+ result[1] +"\" />\n";
	        				population = population + "\t\t\t</plan>\n";

	        		population = population + "\t\t</person>\n\n";
	        	
	        		population = population + "\n\n";
			}
			
		}
		
		return population;
	}
	
	
	public static String selectEvent() {
		String dbURL = "jdbc:mysql://localhost:3306/matsim";
        String username ="root";
        String password = "root";
       
        Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        String query ="SELECT * FROM `nodes` ORDER BY RAND() LIMIT 0,1";
       
        try {
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, "");
           
            //getting PreparedStatment to execute query
            stmt = dbCon.prepareStatement(query);
           
            //Resultset returned by query
            rs = stmt.executeQuery(query);
            String x = null;
            String y = null;
            while(rs.next()){
            	x = rs.getString("x");
                y = rs.getString("y");
            }
            String s= "";
            s = x + "," + y;
            return s;
           
        } catch (SQLException ex) {
           
        } 
		return "";
	}
	
	public static String search_street(String st_name) {
		String dbURL = "jdbc:mysql://localhost:3306/matsim";
        String username ="root";
       
        Connection dbCon = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
       
        String query ="SELECT li.`id` as link_id, si.`street_name` as name  FROM `street_info` si LEFT JOIN  links li ON li.origid=si.`link_id` WHERE si.`street_name` like \"%"+ st_name +"%\" ";
       
        try {
            //getting database connection to MySQL server
            dbCon = DriverManager.getConnection(dbURL, username, "");
           
            //getting PreparedStatment to execute query
            stmt = dbCon.prepareStatement(query);
           
            //Resultset returned by query
            rs = stmt.executeQuery(query);
            String link_id = null;
            String results = "               ";
            while(rs.next()){
            	link_id = rs.getString("link_id");
            	results = results + link_id + "  ,  ";
            }

            results = results.substring(0, results.length() - 1);
            return results;
           
        } catch (SQLException ex) {
           return "No results";
        }
	}
	

	
}
