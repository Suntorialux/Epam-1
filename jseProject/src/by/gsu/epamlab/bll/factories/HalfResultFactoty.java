package by.gsu.epamlab.bll.factories;

import java.io.IOException;
import java.sql.Date;

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
	public IResultDAO getResultDaoFromFactory(ResultFactory resultFactory, String fileName) throws IOException {
		return new ResultImplCsv(fileName, resultFactory);
	}
	
	

	@Override
	protected double setMean(double mean) {
		return mean/2;
	}

}
