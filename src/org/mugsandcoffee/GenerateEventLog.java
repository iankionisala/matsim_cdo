package org.mugsandcoffee;

public final class GenerateEventLog {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ParseXML pxml = new ParseXML();
		
		// connects to selected database
		pxml.connectToDB();
		
		// read text file here
		
		// loops each line 
		
			// inserts new record
			pxml.insertEvent(12345, "actstart", 14, 14, 38, 11887, "car");
			
		// ends loop
		
		System.out.print("Succeded");

	}

}
