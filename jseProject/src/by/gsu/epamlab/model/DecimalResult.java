package by.gsu.epamlab.model;

import java.sql.Date;

public class DecimalResult extends Result {
	
	
	private final static int TEN = 10;
	
	public DecimalResult(String login, String test, Date date, int mark) {
		super(login, test, date, mark);
	}

	public DecimalResult(String login, String test, Date date, String stringMark) {
		super(login, test, date, stringMark);
	}

	@Override
	public void setMark(String stringMark) {
		int mark = (int)(Double.parseDouble(stringMark)*TEN);
		super.setMark(mark);
	}

	@Override
	public String getStringMark() {
		String stringMark = (getMark()/TEN)+Constans.SEPARATOR_POINT+(getMark()%TEN);
		return stringMark;
	}
	
	@Override
	public String toString() {
		return fieldToString() + getStringMark();
	}
}
