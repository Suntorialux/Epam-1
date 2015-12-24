package by.gsu.epamlab.bll;

import by.gsu.epamlab.model.Result;

public interface IResultDAO {
	 Result nextResult();
	 boolean hasResult();
	 void closeReader();
}
