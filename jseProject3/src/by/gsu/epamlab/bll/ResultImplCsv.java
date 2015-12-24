package by.gsu.epamlab.bll;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Date;
import java.util.Scanner;

import by.gsu.epamlab.model.Constans;
import by.gsu.epamlab.model.Result;
import by.gsu.epamlab.bll.factories.ResultFactory;

public class ResultImplCsv implements IResultDAO{
	
	private static final String START_NAME_FILE = "src/";
	private static final String END_NAME_FILE = ".csv";
	
	private final static int LOGIN_IND = 0;
	private final static int TEST_IND = 1;
	private final static int DATE_IND = 2;
	private final static int MARK_IND = 3;

	
	
	private Scanner scanner;
	private ResultFactory resultFactory;
	Buffer buffer;
	
	
		
	public ResultImplCsv(String nameFile, ResultFactory resultFactory,Buffer buffer) throws IOException  {
		try {
			scanner = new Scanner(new File(START_NAME_FILE+nameFile+END_NAME_FILE));
			if(scanner.hasNextLine()){
				buffer.setProcess(true);;
			}
		} catch (FileNotFoundException e) {
			throw new IOException();
		}
		this.buffer = buffer;
		this.resultFactory = resultFactory;
	}
	
	
	@Override
	public Result nextResult() {
		String [] tmp = scanner.nextLine().split(Constans.RESULT_SEPARATOR);
		String login = tmp[LOGIN_IND].trim();
		String test = tmp[TEST_IND].trim();
		Date date = Date.valueOf(tmp[DATE_IND]);
		String stringMark = tmp[MARK_IND];
		Result result = resultFactory.setResultFromFactory(login, test, date, stringMark);
		buffer.setResult(result);
		if(!scanner.hasNextLine()){
			buffer.setProcess(false);
		}
		return result;
	}

	@Override
	public boolean hasResult() {
		boolean isResult = false;
		if(scanner!=null) {
			isResult = scanner.hasNext();
		}
		return isResult;
	}


	@Override
	public void closeReader() {
		if (scanner!=null) 
			scanner.close();		
	}
}
