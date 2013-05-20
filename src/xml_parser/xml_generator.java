package xml_parser;

import java.awt.*;
import javax.swing.*;
import java.awt.*;
import java.sql.Timestamp;
import java.text.*;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;


public class xml_generator {

	public JMenuItem newGameAction;
	public JMenu fileMenu;
	public JMenuBar menuBar;
	private static String filepath_name;
	private static int total_vehicle;
	private static int minimum = 45;
	
//	private static String filepath = "source/network_coordinates.txt";
	private static String filepath = "source/population_src/police_xy.txt";
	static String result;
	private static void build_frame(){

		String h1 = "Xml Parser";
		JLabel heading;
		JButton rollDice;
		
		
		// start: declaration of Frame
		JFrame frame = new JFrame();
		Container container = frame.getContentPane();	
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
  		int height = screenSize.height;		
  		int width = screenSize.width;
  		int hsize = 400;
  		int wsize = 700;
  		
  		int xlocation = (width/2)-(wsize/2);
 	    int ylocation = ( height/2 ) - ( (hsize/2)+20);
		container.setBackground(new Color(0xFFFFFF));	
		container.setLayout(null);	
		
		// end of JFrame
						//heading or h1
						    Font font1 = new Font("Arial", Font.BOLD, 40);
						    int whsize =470;
						    int hhsize = 40;  
						    heading = new JLabel(h1);
						    heading.setFont(font1);
						    heading.setForeground(Color.red);
						    heading.setSize( whsize , hhsize );
						    heading.setLocation( ((width/2) - whsize) + 50 , 20 );
						    container.add(heading);
						    
						    
						    JLabel filename = new JLabel("Filename: ");
						    Font font2 = new Font("Arial", Font.BOLD, 17);
						    filename.setForeground(Color.black);
						    filename.setFont(font2);
						    filename.setLocation( 100 , 130 );
						    filename.setSize( 100 , 20 );
						    container.add(filename);
						    
						    final TextField textFieldGen = new TextField();	
						    textFieldGen.setBounds(200, 130, 200, 25);
						    container.add(textFieldGen);
						    
						    JLabel filename2 = new JLabel("No. of vehicles: ");
						    filename2.setForeground(Color.black);
						    filename2.setFont(font2);
						    filename2.setLocation( 100 , 180 );
						    filename2.setSize( 130 , 20 );
						    container.add(filename2);
						    
						    final TextField textFieldGen2 = new TextField();	
						    textFieldGen2.setBounds(250, 180, 50, 25);
						    container.add(textFieldGen2);
						    
						    DefaultComboBoxModel model = new DefaultComboBoxModel();
			                
						  				    
							String[] arr = result.split("\\s");
							
							int count = arr.length - 1;
							for(int k = 1; k <= count; k++) {
								
								model.addElement(arr[k]);
								
							}
						    
						    
			                JComboBox comboBox = new JComboBox(model);
			                comboBox.setBounds(200, 200, 100, 25);
			                container.add(comboBox);
			                
			                
						   
			                
						
						rollDice = new JButton("Submt");
						rollDice.setSize(100,30);
						rollDice.setLocation( ((width/2) - whsize) + 100 , 250);
						container.add(rollDice);
						rollDice.addActionListener(new ActionListener() {
				            public void actionPerformed(ActionEvent arg0) {
				            	
				            	filepath_name = textFieldGen.getText();
				            	total_vehicle = Integer.parseInt( textFieldGen2.getText() );
				            	
				            	int maximum = total_vehicle + minimum;
				            	
				            	
				        		

				            	String population = "\n";
				            	
/*				            	for(int i=0; i<total_vehicle;i++){
				            		
				            		int cnt = 150;
					        		
					            	int origin = 0 + (int)(Math.random()* 8 );
					            	int destination = 0 + (int)(Math.random()* cnt );
					            	
				            	    
				            		population = population + "<!-- =============================== random" + i +" ======================================= -->\n\n";

				            		population = population + "\t\t<person id=\""+ (minimum+i+1) +"\" employed=\"yes\">\n";
				            				population = population + "\t\t\t<plan selected=\"yes\">\n";
				            					population = population + "\t\t\t\t<act type=\"origin\" facility=\"0\" "+ result[origin] +"  end_time=\"07:00:00\" />\n";
				            					population = population + "\t\t\t\t\t<leg mode=\"car\" dep_time=\"07:00:00\">\n";
				            					population = population + "\t\t\t\t\t</leg>\n";
				            					population = population + "\t\t\t\t<act type=\"destination\" facility=\"19\" x=\"2368575.0885537993\" y=\"885885.5658242189\" end_time=\"17:00:00\" />\n";
				            					population = population + "\t\t\t\t\t<leg mode=\"car\" dep_time=\"17:00:00\">\n";
				            					population = population + "\t\t\t\t\t</leg>\n";
				            					population = population + "\t\t\t\t<act type=\"origin\" facility=\"0\" "+ result[origin] +" />\n";
				            				population = population + "\t\t\t</plan>\n";

				            		population = population + "\t\t</person>\n\n";
				            			
				            	}*/
				            	
				            	population = population + "\n\n";
				            			            	
				        		file_handler file2 = new file_handler( filepath_name );
				        		file2.create_file( population );
				                JOptionPane.showMessageDialog(null, "\"input/" +filepath_name +"\" has been created");
				                 
				            }
				        });
						
 	    
 	    frame.setSize(wsize, hsize);
 	    frame.setLocation( xlocation, ylocation);
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setTitle( "Snakes and Ladder" );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );	
		
		//end of frame continuition
		
	}
	
	private static boolean is_thesame(int x, int y){
		if(x == y){
			System.out.println("origin equal to destination");
			return true;
		}else{
			System.out.println("origin not equal to destination");
			return false;
		}
	}
	
	private static boolean is_greater(long millis2, long millis){
		if(millis2 > millis){
			return true;
		}else{
			return false;
		}
	}
	
	public static void main(String[] args) {
		file_handler file = new file_handler("" + filepath);
		result = file.parse_data();
		
		build_frame();
	}
	
	
}
