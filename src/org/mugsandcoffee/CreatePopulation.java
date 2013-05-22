package org.mugsandcoffee;


import xml_parser.*;

public class CreatePopulation {
	
	private static String inputtext;
	private static String filepath = "source/population_src/police_xy.txt";
	
	public CreatePopulation(){
		_init();
	}
	
	private static void _init(){
		readFile();
		createFile(inputtext);
	}
	
	private static void createFile(String input){
		file_handler file = new file_handler("input/population.xml");
		file.create_file( input );
	}
	
	private static void readFile(){
		file_handler file = new file_handler(filepath);
		inputtext = file.parse_data();
	}

}
