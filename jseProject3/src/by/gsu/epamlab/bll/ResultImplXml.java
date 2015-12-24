package by.gsu.epamlab.bll;

import java.io.IOException;

import by.gsu.epamlab.model.Result;

public class ResultImplXml implements IResultDAO {


	boolean flag = true;
	private String nameFile;
	private Buffer buffer;
	boolean isResult;
			
	public ResultImplXml(String nameFile,Buffer buffer) throws IOException {
		this.nameFile = nameFile;
		this.buffer = buffer;
	}

	@Override
	public Result nextResult() {
		Result result = null;
		
		if (flag){
			
			ResultsSAXBuilder saxBuilder = new ResultsSAXBuilder(buffer);
			try {
				
				saxBuilder.buildListResults(nameFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
			flag = false;
		}
	
		return result;
	}
	

	public void setResult(boolean isResult) {
		this.isResult = isResult;
	}

	@Override
	public boolean hasResult() {
		
		
		return !buffer.hasResult();
	}

	@Override
	public void closeReader() {
			
	
	}
}
