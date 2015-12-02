package by.gsu.epamlab;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class SimpleStudentHandler extends DefaultHandler{
	
	
	private List<Result> results;
	private Result result;
	private BuildResult buildResult;
	private String thisElement;
	private boolean isLogin;
	private boolean isStudent;
	private String login;
	
	
	private enum Tags{
		RESULTS,STUDENT,LOGIN,TESTS,TEST
	}
	
	
	
	SimpleStudentHandler (){
		isLogin = false;
		isStudent = false;
		results = new ArrayList<>();
		
	}
	@Override
	public void startDocument() throws SAXException {
		//System.out.println("Parsing started");
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {

		thisElement = localName.toUpperCase();
		switch(Tags.valueOf(thisElement)){
			case STUDENT: 
				isStudent = true;
				isLogin = true;
				break;
				
			case TEST: 
	
					buildResult = new BuildResult(attrs.getValue(0), attrs.getValue(1), attrs.getValue(2),login);
					try {
						result = buildResult.getResult();
					} catch (ParseException e) {
						
						e.printStackTrace();
					}
					results.add(result);
			
				break;
		}
	}
	

	@Override
	public void characters(char[ ] ch, int start, int length) throws SAXException {
		switch(Tags.valueOf(thisElement)){
		case LOGIN:
			if (isLogin){
				isLogin = false;
				login = new String(ch,start,length);
			}
			break;
		}
	}
	

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.equals("student")){
		
				isStudent = false;
		}
	}
	
	@Override
	public void endDocument() {
	  for(Result tmp: results){
		   System.out.println(tmp);
	   }
	}

}
