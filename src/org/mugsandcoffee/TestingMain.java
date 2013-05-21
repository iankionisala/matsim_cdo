package org.mugsandcoffee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.matsim.api.core.v01.Coord;
import org.matsim.core.basic.v01.IdImpl;
import org.matsim.core.facilities.ActivityFacilityImpl;
import org.matsim.core.scenario.ScenarioImpl;
import org.matsim.core.utils.geometry.CoordImpl;

/**
 * This Class created for testing purposes.
 * @author Mugs and Coffee
 * @coder Ian Paul F. Kionisala
 * @since Sunday, May 19, 2013
 * @version 1.0
 *
 */

public class TestingMain {
	
	public String[] result;
	public String out = "";

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/* Create network.xml */
/*		CreateNetwork network = new CreateNetwork();
		network.generateNetwork();*/
		
		/* Create facilities.xml */
/*		CreateFacilities facilities = new CreateFacilities();
		facilities.generateFacilities();  */
		
		/* Create output files */
		/* CreateOutput output = new CreateOutput();
		output.generateOutput();  */
		
		TestingMain main = new TestingMain();
		main.readBusinessCensus();
		
		String[] arr = main.out.split("\\s");
		
		//System.out.println(arr.length);
		int count = arr.length - 1;
		for(int k = 1; k <= count; k++) {
			
			System.out.println(arr[k]);
		}

	}
	
	private boolean readBusinessCensus() {
		
		String parsed_text = read_textfile();
		
		result = parsed_text.split("\n"); 
		for(int i = 0; i < result.length; i++) {
			
			String[] res = result[i].split("\\s");
		
			 out = out + " " +res[2];
		}
		
		return true;
	}
	

	public String read_textfile() {
	    String text = "";
	    int read, N = 1024 * 1024;
	    char[] buffer = new char[N];

	    try {
	        FileReader fr = new FileReader("source/population_src/police_xy.txt");
	        BufferedReader br = new BufferedReader(fr);

	        while(true) {
	            read = br.read(buffer, 0, N);
	            text += new String(buffer, 0, read);

	            if(read < N) {
	                break;
	            }
	        }
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }

	    return text;
	}

}
