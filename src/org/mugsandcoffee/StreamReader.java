package org.mugsandcoffee;

import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
//import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
//import org.w3c.dom.Element;
import java.io.File;

public class StreamReader {
	
	private File eventFile;
	private DocumentBuilderFactory docGeneratorFactory;
	private DocumentBuilder docGenerator;
	private Document objDOM;
	
//	File fXmlFile = new File("./input/parse/run0.0.events.xml");		
//	DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
//	DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
//	Document doc = dBuilder.parse(fXmlFile);

	public StreamReader(String evtFile) {
		
		try {
			// initializes some member variables
			this.eventFile = new File("./input/parse/" +  evtFile);
			this.docGeneratorFactory = DocumentBuilderFactory.newInstance();
			this.docGenerator = this.docGeneratorFactory.newDocumentBuilder();
			this.objDOM = this.docGenerator.parse(this.eventFile);
			
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			this.objDOM.getDocumentElement().normalize();
			
		} catch(Exception e) {
			System.out.println("StreamReader Constructor: " + e.getMessage());
		}
		
	}
	
	public NodeList getAllObjects() {
		NodeList objNodes = null;
		
		try {
			
			objNodes = this.objDOM.getElementsByTagName("event");
			
		}catch(Exception e) {
			System.out.println("getAllObjects: " +  e.getMessage());
		}
		
		return (NodeList)objNodes;
	}

}
