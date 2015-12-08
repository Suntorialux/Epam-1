package by.gsu.epamlab.bll;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.gsu.epamlab.model.Querys;
import by.gsu.epamlab.model.Test;


public class DAO {
	private SqlConnector sqlConnector;
	private static Connection cn;
	private Statement st;
	private ResultSet rs;
	private PreparedStatement ps;

	public DAO(SqlConnector sqlConnector) {
		this.sqlConnector = sqlConnector;
	}
	
	public static void sqlWriter(Test tests) throws SQLException{
		//вставка в базу обьекта Tests
		PreparedStatement preparedStatement = cn.prepareStatement(Querys.INSERT_QUERY);
	}
	
	public static Test sqlReader(){
		//чтение из базы и запись в обьект Tests
		return new Test();
	}
	
	
	
	
}
