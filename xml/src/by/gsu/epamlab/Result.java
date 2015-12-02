package by.gsu.epamlab;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Result {
	private  String login;
	private  String test;
	private  Date date;
	private int mark;
	
	private SimpleDateFormat dateInput =new SimpleDateFormat("yyyy-mm-dd");
    private SimpleDateFormat dateOutput =new SimpleDateFormat("dd.mm.yyyy");
	
	public Result(){
		
	} 
	public Result(String login, String test, String date, String mark) throws ParseException {
		String[] markSplit= mark.split("\\.");
		this.login = login;
		this.test = test;
		
		this.date = dateInput.parse(date);
		this.mark = Integer.parseInt(markSplit[0]+markSplit[1]);;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getTest() {
		return test;
	}


	public void setTest(String test) {
		this.test = test;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getMark() {
		return mark;
	}


	public void setMark(int mark) {
		this.mark = mark;
	}


	


	@Override
	public String toString() {
		return login + ";" + test + ";" + dateOutput.format(this.date) + ";" + mark;
	}
	
	
	
	
}
