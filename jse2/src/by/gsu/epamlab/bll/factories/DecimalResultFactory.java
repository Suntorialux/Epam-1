package by.gsu.epamlab.bll.factories;

import java.io.IOException;
import java.sql.Date;

import by.gsu.epamlab.bll.IResultDAO;
import by.gsu.epamlab.bll.ResultImplXml;
import by.gsu.epamlab.model.DecimalResult;
import by.gsu.epamlab.model.Result;

public class DecimalResultFactory extends ResultFactory {
	
	@Override
	public Result getResultFromFactory(String login, String test, Date date, int mark) {
		return new DecimalResult(login, test, date, mark);
	}

	@Override
	public IResultDAO getResultDaoFromFactory(ResultFactory resultFactory, String fileName)throws IOException {
		return new ResultImplXml(fileName);
	}
	
	@Override
	protected double setMean(double mean) {
		return mean/10;
	}
		
}
