package by.gsu.epamlab.bll;

import java.io.IOException;
import java.util.Iterator;

import by.gsu.epamlab.model.Result;

public class ResultImplXml implements IResultDAO {


	boolean flag = true;
	String nameFile;
	Buffer buffer;
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
				// TODO Auto-generated catch block
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
		
		
		return true;
	}

	@Override
	public void closeReader() {
			
	
	}
}
