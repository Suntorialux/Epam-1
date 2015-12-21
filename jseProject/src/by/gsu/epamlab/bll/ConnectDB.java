package by.gsu.epamlab.bll;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Enumeration;
import java.util.ResourceBundle;

import org.omg.PortableInterceptor.USER_EXCEPTION;
import by.gsu.epamlab.model.*;
import com.mysql.jdbc.Driver;

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
	private static void createConnection() throws ClassNotFoundException {
		loadSettings();
		try {
			Class.forName(DRIVER);
			cn = DriverManager.getConnection(DB_URL,USER, PASSWORD);
		} catch (SQLException e) {
			//throw new ConnectionException(Constants.ERROR_LOAD);
		}
		
	}

	public static Connection getConnection() throws ClassNotFoundException {
		if (cn == null){
			createConnection();
		}
		return cn;
	}
	
	public static void closeResultSet(ResultSet resultSet) {
		 if(resultSet!=null) {
			 try {
				resultSet.close();
			} catch (SQLException e) {
				System.err.println(Constans.ERROR_MESSAGE_RS + e);
			}
		 }
	 }
	 
	 public static void closePreparedStatement (PreparedStatement preparedStatement) {
		 if(preparedStatement!=null) {
			 try {
				preparedStatement.close();
			} catch (SQLException e) {
				System.err.println(Constans.ERROR_MESSAGE_PS + e);
			}
		 }
	 }
	 
	 public static void closeConnection (Connection connection) {
		 if (connection!=null) {
			 try {
				connection.close();
			} catch (SQLException e) {
				System.err.println(Constans.ERROR_MESSAGE_CON + e);
			}
		 }
	 }
}
