package by.gsu.epamlab.bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

public class SqlConnector {
	private static SqlConnector sqlConnector;
	
	private Connection cn;
	
	private  String DB_URL;
	private  String USER;
	private  String PASSWORD;
	private  String DRIVER;
	
	public SqlConnector () throws ClassNotFoundException, SQLException{
		
		ResourceBundle resourcesBundle = ResourceBundle.getBundle("settings");
		 Enumeration<String> resourcesKey=resourcesBundle.getKeys();
		 
		 while (resourcesKey.hasMoreElements()){
	            String key=resourcesKey.nextElement();
	            if (key.compareTo("db.url")==0){DB_URL=resourcesBundle.getString(key).trim();}
	            if (key.compareTo("db.user")==0){USER=resourcesBundle.getString(key).trim();}
	            if (key.compareTo("db.password")==0){PASSWORD=resourcesBundle.getString(key).trim();}
	            
	            if (key.compareTo("db.driver")==0){DRIVER=resourcesBundle.getString(key).trim();}
	        }
		Class.forName(DRIVER);
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
}
