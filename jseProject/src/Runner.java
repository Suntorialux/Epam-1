import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.Scanner;

import by.gsu.epamlab.bll.CsvReader;
import by.gsu.epamlab.bll.SqlConnector;

public class Runner {
	
	static final String DB_URL = "jdbc:mysql://localhost/results";
	 static final String USER = "jse";
	 static final String PASSWORD = "jse";
	 static final String INSERT_QUERY = "INSERT INTO logins(name) VALUES(?)";
	

	public static void main(String[] args) throws FileNotFoundException{
		
		Scanner scanner = null;
		
		
		scanner = new Scanner(new FileReader("src/in.csv"));
		
		
			CsvReader csvr = new CsvReader(scanner);
			while(scanner.hasNextLine()){
				System.out.println(csvr.read());
			}
		
		
		
//		SqlConnector sqlConnector = null;
//		try {
//			sqlConnector = SqlConnector.getInstans();
//		} catch (ClassNotFoundException | SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
//		Connection cn = sqlConnector.getCn();
//		try {
//			PreparedStatement preparedStatement = cn.prepareStatement(INSERT_QUERY);
//			preparedStatement.setString(1,"aaaaaaaaaaa");
//			preparedStatement.executeUpdate();
//		} catch (SQLException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		try {
//			Statement st = cn.createStatement();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		ResultSet rs = null;
//		
		

		
		

	}

}
