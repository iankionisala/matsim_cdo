package org.mugsandcoffee;

import xml_parser.file_handler;

public class CreateLinks {


	public static String nodes;
	private static String filepath = "input/parse/coordlink.txt";
	
	public CreateLinks(){
		_init();
	}
	
	private static String _init(){
		readFile();
		return nodes;
	}
	
	private static void readFile(){
		file_handler file = new file_handler(filepath);
		nodes = file.parse_data();
	}
	
	
	


}
