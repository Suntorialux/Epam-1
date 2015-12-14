package by.gsu.epamlab.bll;

import by.gsu.epamlab.model.Result;

public class ResultsLoader {
	
	IResultDAO reader;
	
	
	public static void loadResults(IResultDAO reader){
		
		while(reader.hasResult()) { 
		      Result result = reader.nextResult(); 
		      String login = result.getLogin(); 
		      String test = result.getTest(); 
		
		}
		  
    } 
}
