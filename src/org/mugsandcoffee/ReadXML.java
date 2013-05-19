package org.mugsandcoffee;
import javax.xml.parsers.DocumentBuilderFactory; 
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;
import java.io.File;

public class ReadXML {

	/**
	 * This is the main executing file
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			 
			File fXmlFile = new File("./input/parse/run0.0.events.xml");		
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);
		 
			//optional, but recommended
			//read this - http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();
		 
//			System.out.println("Root element :" + doc.getDocumentElement().getNodeName());		 
			NodeList nList = doc.getElementsByTagName("event");		 
//			System.out.println("----------------------------");
		 
			for (int temp = 0; temp < nList.getLength(); temp++) {		 
				Node nNode = nList.item(temp);		 
				System.out.println("\nCurrent Element :" + nNode.getNodeName());
				System.out.println("----------------------------");
				if (nNode.getNodeType() == Node.ELEMENT_NODE) {		 
					Element eElement = (Element)nNode;					 
					System.out.println("Time : " + eElement.getAttribute("time"));
					System.out.println("Act Type: " +  eElement.getAttribute("type"));
					System.out.println("Person: " + eElement.getAttribute("person"));
					System.out.println("Vehicle: " + eElement.getAttribute("vehicle"));
					System.out.println("Facility: " +  eElement.getAttribute("facility"));
					System.out.println("Link : " +  eElement.getAttribute("link"));
					System.out.println("Leg Mode: " + eElement.getAttribute("legMode"));
					
		 
				}
			}
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
		  }

}
