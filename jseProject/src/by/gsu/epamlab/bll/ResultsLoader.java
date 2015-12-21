package by.gsu.epamlab.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.gsu.epamlab.model.Result;

public class ResultsLoader {
	
	IResultDAO reader;
	
	private ConnectDB sqlConnector;
	private static Connection cn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;
	
	private final static String SELECT_LOGIN = "select idLogin from logins where name=(?)";
	private final static String INSERT_LOGIN = "INSERT INTO logins (name) VALUES (?)";
	private final static String SELECT_TEST = "select idTest from tests where name=(?)"; 
	private final static String INSERT_TEST = "INSERT INTO tests (name) VALUES (?)";
	private final static String CREATE_NEW_RESULT="INSERT INTO results" +
            "(loginId, testId, dat, mark) VALUES (?,?,?,?)";
	
	
	public static void loadResults(IResultDAO reader){
		
		Connection cn = null;
		PreparedStatement psInsertLogin = null;
		PreparedStatement psSelectLogin = null;
		PreparedStatement psInsertTest = null;
		PreparedStatement psSelectTest = null;
		PreparedStatement psCreateNewResult = null;
		
		try {
			cn = ConnectDB.getConnection();
			psInsertLogin = cn.prepareStatement(INSERT_LOGIN);
			psSelectLogin = cn.prepareStatement(SELECT_LOGIN);
			psInsertTest = cn.prepareStatement(INSERT_TEST);
			psSelectTest = cn.prepareStatement(SELECT_TEST);
			psCreateNewResult = cn.prepareStatement(CREATE_NEW_RESULT);
			
			while(reader.hasResult()) { 
			      Result result = reader.nextResult(); 
			      String login = result.getLogin(); 
			      String test = result.getTest(); 
			      int idLogin =  getId(login,psSelectLogin,psInsertLogin);
			      int idTest = getId(test,psSelectTest,psInsertTest);
			      
			      psCreateNewResult.setInt(1, idLogin);
			      psCreateNewResult.setInt(2, idTest);
			      psCreateNewResult.setDate(3,result.getDate());
			      psCreateNewResult.setInt(4, result.getMark());
			      psCreateNewResult.executeUpdate();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			reader.closeReader();

			ConnectDB.closePreparedStatement(psInsertLogin);
			ConnectDB.closePreparedStatement(psInsertTest);
			ConnectDB.closePreparedStatement(psSelectLogin);
			ConnectDB.closePreparedStatement(psSelectTest);
			//ConnectDB.closeConnection(cn);
		}
			
		
		
			
		
		  
    } 
	
	private static int getId(String login,PreparedStatement psSelect,PreparedStatement psInsert) throws SQLException{
		int id = 0;
		psSelect.setString(1, login);
		ResultSet rs = psSelect.executeQuery();
		if (rs.next()){
			id = rs.getInt(1);
		}else {
			psInsert.setString(1,login);
			psInsert.executeUpdate();
			id = getId(login,psSelect,psInsert);
		}
		
		return id;
		
	}
	
	
		
	
}
