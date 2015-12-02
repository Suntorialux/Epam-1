package by.gsu.epamlab;

import java.text.ParseException;


public class BuildResult {
	private  String login;
	private  String test;
	private  String date;
	private String mark;
	
	public BuildResult() {
		this.test = null;
		this.date = null;
		this.mark = null;
	}
	
	public BuildResult(String test, String date, String mark,String login) {
		this.test = test;
		this.date = date;
		this.mark = mark;
		this.login = login;
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

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getMark() {
		return mark;
	}

	public void setMark(String mark) {
		this.mark = mark;
	} 
	
	public Result getResult() throws ParseException{
		return new Result(login,test,date,mark);
	}
	
	
}
