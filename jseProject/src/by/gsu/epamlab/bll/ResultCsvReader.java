package by.gsu.epamlab.bll;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import by.gsu.epamlab.model.Result;

public class ResultCsvReader implements IResultDAO {
	
	private String filePath;
	private Scanner scanner;
	private final String SEPARATOR = ";"; 
	private boolean isResult = false;
	

	public ResultCsvReader(String filePath) throws FileNotFoundException {
		scanner = new Scanner(new FileReader(filePath));
		this.filePath = filePath;
	}

	@Override
	public Result nextResult() {
		Result result = null;
		if (scanner.hasNext()){
			String resultLine = scanner.nextLine();
			String [] tmp = resultLine.split(SEPARATOR);
			result = new Result(tmp[0], tmp[1], tmp[2], tmp[3]);
		}
		return result;
	}

	@Override
	public boolean hasResult() {
		if (scanner.hasNext()){
			isResult = true;
		}else isResult = false;
		return isResult;
	}

	@Override
	public void closeReader() {
		if (scanner != null) {
			scanner.close();
		}
		
	}

	

}
