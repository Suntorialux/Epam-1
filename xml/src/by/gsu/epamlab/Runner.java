package by.gsu.epamlab;


import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;



public class Runner {
	public static void main(String[ ] args) throws ParserConfigurationException {
		
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			SimpleStudentHandler handler = new SimpleStudentHandler();
			reader.setContentHandler(handler);
			
			reader.parse("src/students.xml"); 
		} catch (SAXException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
		

