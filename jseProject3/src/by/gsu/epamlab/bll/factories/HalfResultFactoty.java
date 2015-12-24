package by.gsu.epamlab.bll.factories;

import java.io.IOException;
import java.sql.Date;

import by.gsu.epamlab.bll.Buffer;
import by.gsu.epamlab.bll.IResultDAO;
import by.gsu.epamlab.bll.ResultImplCsv;
import by.gsu.epamlab.model.HalfResult;
import by.gsu.epamlab.model.Result;

public class HalfResultFactoty extends ResultFactory {

	
	@Override
	public Result setResultFromFactory(String login, String test, Date date, String stringMark) {
		return new HalfResult(login, test, date, stringMark);
	}

	@Override
	public Result getResultFromFactory(String login, String test, Date date, int mark) {
		return new HalfResult(login, test, date, mark);
	}

	@Override
	public IResultDAO getResultDaoFromFactory(ResultFactory resultFactory, String fileName,Buffer buffer) throws IOException {
		return new ResultImplCsv(fileName, resultFactory,buffer);
	}
	
	

	@Override
	protected double setMean(double mean) {
		return mean/2;
	}

}
