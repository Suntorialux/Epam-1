package by.gsu.epamlab.bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Enumeration;
import java.util.ResourceBundle;

import by.gsu.epamlab.model.Constans;

public class ConnectDB {
	private static Connection cn;
	
		
	private static  String DB_URL;
	private static  String USER;
	private static  String PASSWORD;
	private static  String DRIVER;
	
	
	
	private ConnectDB (){
		
	}
	
	private static void loadSettings(){
		ResourceBundle resourcesBundle = ResourceBundle.getBundle("settings");
		Enumeration<String> resourcesKey=resourcesBundle.getKeys();
		while (resourcesKey.hasMoreElements()){
            String key=resourcesKey.nextElement();
            if (key.compareTo("db.url")==0){DB_URL=resourcesBundle.getString(key).trim();}
            if (key.compareTo("db.user")==0){USER=resourcesBundle.getString(key).trim();}
            if (key.compareTo("db.password")==0){PASSWORD=resourcesBundle.getString(key).trim();}
            if (key.compareTo("db.driver")==0){DRIVER=resourcesBundle.getString(key).trim();}
        }
	}
	
	public static synchronized Connection getConnection() throws ConnectionException {
		loadSettings();
		try {
			if (cn == null||cn.isClosed()) {
				Class.forName(DRIVER);
				cn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			}
		} catch (ClassNotFoundException | SQLException e) {
			throw new ConnectionException("ERROR: Connection to database is failed ");
		}
			
		return cn;
	}

	
	public static void closeResultSet(ResultSet resultSet) {
		 if(resultSet!=null) {
			 try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.err.println(Constans.ERROR_MESSAGE_RS + e);
			}
		 }
	 }
	
	 public static void closeStatement (Statement... statements) {
		 for(Statement statement : statements) {
			 try {
				 if(statement!=null) {
					 statement.close();
				 }
			} catch (SQLException e) {
				System.err.println(Constans.ERROR_MESSAGE_PS + e);
			}
		 }
	 }
	 
	 public static void closeConnection () {
		 if (cn!=null) {
			 try {
				cn.close();
			} catch (SQLException e) {
				System.err.println(Constans.ERROR_MESSAGE_CON + e);
			}
		 }
	 }
}
