package org.menu_builder;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JLabel;

public class mainMenu {
	
	
	private static LayoutBuilder layout;

	public static void main(String[] args) {
		layout = new LayoutBuilder(500, 500, "Mam Bing Menu");
		
		Font font = new Font("Arial", Font.BOLD, 17);
		Color color= null;
		color = color.red;
		
		JLabel lbl = layout.buildJLabel("Ian", font, 50, 50, color, 20, 20);
		layout.addbuilder(lbl);
		
		JLabel lbl2 = layout.buildJLabel("tongbens", font, 50, 50, color, 20, 20);
		layout.addbuilder(lbl2);
	}
	
	
	
	
	
}
