package org.mugsandcoffee;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import org.apache.log4j.Logger;
import org.matsim.api.core.v01.Coord;
import org.matsim.api.core.v01.Scenario;
import org.matsim.core.api.experimental.facilities.ActivityFacility;
import org.matsim.core.basic.v01.IdImpl;
import org.matsim.core.config.Config;
import org.matsim.core.config.ConfigUtils;
import org.matsim.core.facilities.ActivityFacilityImpl;
import org.matsim.core.facilities.ActivityOptionImpl;
import org.matsim.core.facilities.FacilitiesWriter;
import org.matsim.core.facilities.OpeningTimeImpl;
import org.matsim.core.facilities.OpeningTime.DayType;
import org.matsim.core.scenario.ScenarioImpl;
import org.matsim.core.scenario.ScenarioUtils;
import org.matsim.core.utils.geometry.CoordImpl;

import xml_parser.file_handler;

public class CreateFacilities {

	private static String inputtext;
	private static String filepath = "input/parse/facility.txt";
	
	public CreateFacilities(){
		_init();
	}
	
	private static void _init(){
		readFile();
		createFile(inputtext);
	}
	
	private static void createFile(String input){
		file_handler file = new file_handler("input/facilities.xml");
		file.create_file( input );
	}
	
	private static void readFile(){
		file_handler file = new file_handler(filepath);
		inputtext = file.parse_data();
	}

}
