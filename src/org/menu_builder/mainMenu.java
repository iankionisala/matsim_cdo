package org.menu_builder;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

import org.mugsandcoffee.CreateFacilities;
import org.mugsandcoffee.CreateNetwork;
import org.mugsandcoffee.CreateOutput;
import org.mugsandcoffee.CreatePopulation;


public class mainMenu {
	
	
	private static LayoutBuilder layout;

	public static void main(String[] args) {
		layout = new LayoutBuilder( 350, 800, "Mam Bing Menu");
		
		Font font = new Font("Arial", Font.BOLD, 17);
		Color color= null;
		color = color.blue;
		
		JLabel lbl = layout.buildJLabel("Matsim Project", font, 120, 15, color, ((layout.scrnwidth/4) - (120/8)), 10);
		layout.addbuilder(lbl);
		
		JButton btn = layout.buildJButton("Create Network", 150, 50, 40, 50);
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
		JButton btn2 = layout.buildJButton("Create Facilities", 150, 50, 210, 50);
		layout.addbuilder(btn2);
		
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 
        		/* Create facilities.xml */
            	CreateFacilities facilities = new CreateFacilities();
            	facilities.generateFacilities();
            	
            	JOptionPane.showMessageDialog(null, "Successfully Created facilities.xml");
            	
            }
        });
		
		JButton btn3 = layout.buildJButton("Create Population", 150, 50, 40,  115);
		layout.addbuilder(btn3);
		
		btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	new CreatePopulation();
            	
            	JOptionPane.showMessageDialog(null, "Successfully Created population.xml");
            }
        });
		
		JButton btn4 = layout.buildJButton("Create Output", 150, 50, 210, 115);
		layout.addbuilder(btn4);
		
		btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 
        		/* Create output files */
        		CreateOutput output = new CreateOutput();
        		output.generateOutput(); 
        		
        		JOptionPane.showMessageDialog(null, "Successfully Created Output Folder");
            	
            }
        });
		
		JButton btn5 = layout.buildJButton("Add road closure", 150, 50, 40, 180);
		layout.addbuilder(btn5);
		
		btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 JOptionPane.showMessageDialog(null, "tongbens gwapo");
            }
        });
		
		//buttons
		JButton btn6 = layout.buildJButton("Add Vehicle", 150, 50, 210, 180);
		layout.addbuilder(btn6);
		
		btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	String numvehicles = JOptionPane.showInputDialog("Please input Total No. of Vehicles");
            	int numvec = Integer.parseInt(numvehicles);
            	createAddedPopulation(numvec);
            }
        });
		
		JButton btn7 = layout.buildJButton("Search", 150, 50, 40, 245);
		layout.addbuilder(btn7);
		
		JButton btn8 = layout.buildJButton("Event Log Reports", 150, 50, 210, 245);
		layout.addbuilder(btn8);
		
		btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 JOptionPane.showMessageDialog(null, "tongbens gwapo");
            }
        });
		
	}
	
	private static void createAddedPopulation(int numvehicle){

	    
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
			}
			
			JOptionPane.showMessageDialog(null, "addedPopulation ");
		}
		
		
	}
	
	
	
	
	
}
