package by.gsu.epamlab.model;

import java.sql.Date;

public class Result {
	  private String login; 
	  private String test; 
	  private Date date; 
	  private int mark;
	  
	  private final String SEPARATOR=";";
	  
	public Result(String login, String test, Date date, int mark) {
		this.login = login;
		this.test = test;
		this.date = date;
		this.mark = mark;
	}
	
	
	public Result(String login, String test, String date, String mark) {
		this.login = login;
		this.test = test;
		this.date = Date.valueOf(date);
		this.mark = Integer.parseInt(mark);
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

	
	
	protected String fieldToString(){
        return login + SEPARATOR + test + SEPARATOR+ date + SEPARATOR;
    }

	@Override
	public String toString() {
		return login + SEPARATOR + test + SEPARATOR + date + SEPARATOR + mark;
	} 
	  
	  
}
