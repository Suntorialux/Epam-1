package by.gsu.epamlab.bll.readers;

import java.io.IOException;
import java.util.Iterator;

import by.gsu.epamlab.bll.IResultDAO;
import by.gsu.epamlab.bll.ResultsSAXBuilder;
import by.gsu.epamlab.model.Result;

public class ResultImplXml implements IResultDAO {

	private Iterator<Result> iterator;
	
			
	public ResultImplXml(String nameFile) throws IOException {
		ResultsSAXBuilder saxBuilder = new ResultsSAXBuilder();
		saxBuilder.buildListResults(nameFile);
		this.iterator=saxBuilder.getResults().iterator();
	}

	@Override
	public Result nextResult() {
		Result result = iterator.next();
		return result;
	}

	@Override
	public boolean hasResult() {
		boolean isResult = false;
		if(iterator!=null) {
			isResult = iterator.hasNext();
		}
		return isResult;
	}

	@Override
	public void closeReader() {
			
	
	}
}
