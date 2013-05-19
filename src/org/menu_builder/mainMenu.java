package org.menu_builder;

import java.awt.Color;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import org.mugsandcoffee.CreateFacilities;
import org.mugsandcoffee.CreateNetwork;
import org.mugsandcoffee.CreateOutput;


public class mainMenu {
	
	
	private static LayoutBuilder layout;

	public static void main(String[] args) {
		layout = new LayoutBuilder( 320, 600, "Mam Bing Menu");
		
		Font font = new Font("Arial", Font.BOLD, 17);
		Color color= null;
		color = color.red;
		
		JLabel lbl = layout.buildJLabel("Matsim Project", font, 120, 15, color, 235, 10);
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
		JButton btn2 = layout.buildJButton("Create Facilities", 150, 50, 220, 50);
		layout.addbuilder(btn2);
		
		btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 
        		/* Create facilities.xml */
            	CreateFacilities facilities = new CreateFacilities();
            	facilities.generateFacilities();
            	
            	JOptionPane.showMessageDialog(null, "Successfully Created facilities.xml");
            	
            }
        });
		
		JButton btn3 = layout.buildJButton("Create Population", 150, 50, 400, 50);
		layout.addbuilder(btn3);
		
		btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 JOptionPane.showMessageDialog(null, "Create Population");
            }
        });
		
		JButton btn4 = layout.buildJButton("Create Output", 150, 50, 220, 130);
		layout.addbuilder(btn4);
		
		btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 
        		/* Create output files */
        		CreateOutput output = new CreateOutput();
        		output.generateOutput(); 
        		
        		JOptionPane.showMessageDialog(null, "Successfully Created Output Folder");
            	
            }
        });
		
		JButton btn5 = layout.buildJButton("Add road closure", 150, 50, 40, 210);
		layout.addbuilder(btn5);
		
		btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 JOptionPane.showMessageDialog(null, "tongbens gwapo");
            }
        });
		
		//buttons
		JButton btn6 = layout.buildJButton("Add Vehicle", 150, 50, 220, 210);
		layout.addbuilder(btn6);
		
		btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 JOptionPane.showMessageDialog(null, "tongbens gwapo");
            }
        });
		
		JButton btn7 = layout.buildJButton("Search", 150, 50, 400, 210);
		layout.addbuilder(btn7);
		
		btn7.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	 JOptionPane.showMessageDialog(null, "tongbens gwapo");
            }
        });
		
	}
	
	
	
	
	
}
