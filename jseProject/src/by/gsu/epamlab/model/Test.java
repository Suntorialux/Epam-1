package by.gsu.epamlab.model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Test {
	private String name;
	private String testName;
	private Date date;
	private int mark;
	
	private SimpleDateFormat dateInput =new SimpleDateFormat("dd-mm-yyyy");
    private SimpleDateFormat dateOutput =new SimpleDateFormat("dd-mm-yyyy");
    
    public Test(){
		this.name = null;
		this.testName = null;
		this.date = null;
		this.mark = 0;
	}
	
	public Test(String name, String test, String date, String mark) throws ParseException {
		this.name = name;
		this.testName = test;
		this.date = dateInput.parse(date);
		this.mark = Integer.parseInt(mark);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTestName() {
		return testName;
	}

	public void setTestName(String testName) {
		this.testName = testName;
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
		return name + ";" + testName + ";" + dateOutput.format(this.date) + ";" + mark;
	}
	
	
	
	

}

