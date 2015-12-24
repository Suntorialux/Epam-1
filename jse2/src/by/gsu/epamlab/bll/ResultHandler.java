package by.gsu.epamlab.bll;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import by.gsu.epamlab.model.DecimalResult;
import by.gsu.epamlab.model.Result;

public class ResultHandler extends DefaultHandler{
	
	private static final String NAME = "name";
	private static final String DATE = "date";
	private static final String MARK = "mark";
	
	private static enum ResultEnum { 
		RESULTS,STUDENT,LOGIN,TESTS,TEST;
	}
	
	private List<Result> results;
	private Result result; 
	private String login;
    private ResultEnum resultEnum;

	
	public List<Result> getResults() {
		return results;
	}
	
	public ResultHandler() {
		this.results = new ArrayList<Result>();
	}

	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) throws SAXException {
		resultEnum = ResultEnum.valueOf(localName.toUpperCase());
		if(resultEnum==ResultEnum.TEST) {
			String nameTest = attrs.getValue(NAME).trim();
			String dateString = attrs.getValue(DATE).trim();
			Date date = Date.valueOf(dateString);
			String markString = attrs.getValue(MARK).trim();
			result = new DecimalResult(login, nameTest, date, markString);
			results.add(result);	
		}
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if(resultEnum==ResultEnum.LOGIN) {
			String tmp = new String(ch, start, length).trim();
			if(!tmp.isEmpty()) {
				login = tmp;
			}
		}
	}
}
