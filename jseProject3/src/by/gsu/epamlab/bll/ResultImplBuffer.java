package by.gsu.epamlab.bll;

import by.gsu.epamlab.model.Result;

public class ResultImplBuffer implements IResultDAO{
	
	private Buffer buffer;
	private IResultDAO reader;
	
	
	public ResultImplBuffer(Buffer bufer, IResultDAO reader) {

		this.buffer = bufer;
		this.reader = reader;
	}
	
	@Override
	public Result nextResult() {
		
		Result result = buffer.getResult();
		return result;
	}

	@Override
	public boolean hasResult() {
		boolean isResult = false;
		
		if(reader.hasResult()) {
			isResult = true;
		}
		return isResult;
	}

	@Override
	public void closeReader() {

		
	}

	
}
