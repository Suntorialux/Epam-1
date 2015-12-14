import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



import by.gsu.epamlab.bll.IResultDAO;
import by.gsu.epamlab.bll.ResultCsvReader;
import by.gsu.epamlab.bll.ResultsLoader;
import by.gsu.epamlab.bll.SqlConnector;import by.gsu.epamlab.model.Result;

public class Runner {

	private final static String FILE_PATH = "src/in.csv";
	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		
		

		IResultDAO irs;
		try {
			irs = new ResultCsvReader(FILE_PATH);
			ResultsLoader.loadResults(irs);
		} catch (FileNotFoundException e) {
			System.err.println("File with data not found");
		}
		
		
	}

}
