package by.gsu.epamlab.model;

import java.sql.Date;

public class HalfResult extends Result {
	
	
	private final static int TWO = 2;
	
	public HalfResult(String login, String test, Date date, int mark) {
		super(login, test, date, mark);
	}
	
	public HalfResult(String login, String test, Date date, String StringMark) {
		super(login, test, date, StringMark);
	}

	@Override
	public void setMark(String stringMark) {
		int mark = (int)(Double.parseDouble(stringMark)*TWO);
		super.setMark(mark); 
	}

	@Override
	public String getStringMark() {
		String stringMark=String.valueOf(getMark()/TWO);
		if(getMark()%TWO!=0) {
			stringMark += Constans.SEPARATOR_POINT+getMark()*5%10;
		}
		return stringMark;
	}
}
