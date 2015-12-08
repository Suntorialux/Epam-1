package by.gsu.epamlab.bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SqlConnector {
	private static SqlConnector sqlConnector;
	
	private Connection cn;
	
	
	private final String DB_URL = "jdbc:mysql://localhost/results";
	private final String USER = "jse";
	private final String PASSWORD = "jse";
	
	private SqlConnector() throws ClassNotFoundException, SQLException{
		Class.forName("org.gjt.mm.mysql.Driver");
		cn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
	} 
	
	public static SqlConnector getInstans() throws ClassNotFoundException, SQLException{
		if(sqlConnector == null){
			sqlConnector = new SqlConnector();
		}
		return sqlConnector;
	}

	public Connection getCn() {
		return cn;
	}

	public void setCn(Connection cn) {
		this.cn = cn;
	}
	
	
}
