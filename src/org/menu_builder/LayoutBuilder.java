package org.menu_builder;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class LayoutBuilder {
	
	private JFrame frame;
	private Container container;
	private Dimension screenSize;
	public int _mheight;		
	public int _width;
	public int xlocation;
	public int ylocation;
	
	
	
	public LayoutBuilder( int height, int width, String title){
		frame = new JFrame();
		container = frame.getContentPane();	
		screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setTitle( "Snakes and Ladder" );
		
		_mheight = height;
		_width = width;
		
		int scrnheight = screenSize.height;		
  		int scrnwidth = screenSize.width;
  		
  		int hsize = height;
  		int wsize = _width;
  		
  		xlocation = (scrnwidth/2)-(wsize/2);
 	    ylocation = ( scrnheight/2 ) - ( (hsize/2)+20);
		container.setBackground(new Color(0xFFFFFF));	
		container.setLayout(null);	
		
		frame.setSize(wsize, hsize);
 	    frame.setLocation( xlocation, ylocation);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle( title );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
	}
	
	protected JLabel buildJLabel(String title, Font font, int Jlbl_height, int Jlbl_width, Color color, int xlocation, int ylocation){
		JLabel JLbl;
		JLbl = new JLabel(title);
		JLbl.setFont(font);
		JLbl.setForeground(color);
		JLbl.setSize( Jlbl_height , Jlbl_width );
		JLbl.setLocation( Jlbl_height - Jlbl_height + xlocation , ylocation );
		return JLbl;
		
	}
	
	protected JButton buildJButton( String title, int height, int width , int xlocation, int ylocation){
		
		JButton jb = new JButton( title );
		jb.setSize( height ,width);
		jb.setLocation( xlocation , ylocation);
		return jb;
	}
	
	protected void addbuilder(Component comp){
		 
		 container.add(comp);
	}
}
