package by.gsu.epamlab;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Runner {
	
	 static final String SELECT_AND_ROUND_QUERY = "SELECT round(abs(x1-x2)+0.1) as len, count(round(abs(x1-x2)+0.1)) as cnt FROM coordinates group by len order by cnt desc";
	 static final String DELETE_QUERY = "DELETE FROM frequencies";
	 static final String INSERT_QUERY = "INSERT INTO frequencies(Len, Num) VALUES(?, ?)";
	 static final String SELECT_FROM_FREQ = "SELECT * FROM frequencies WHERE len>num"; 
	 
	 static final String DB_URL = "jdbc:mysql://localhost/segments";
	 static final String USER = "prz";
	 static final String PASSWORD = "123";
	 
	 
	public static void main(String[] args) {
		
		List<Frequencies> frequencies;
		Connection cn = null;
		Statement st = null;
		ResultSet rs = null;
		// loading driver
		try {
			frequencies = new ArrayList<>();
			Class.forName("org.gjt.mm.mysql.Driver");
			cn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
			
			st = cn.createStatement();
			
			rs = st.executeQuery(SELECT_AND_ROUND_QUERY);
			
			while (rs.next()) {
				frequencies.add(new Frequencies(rs.getInt(1), rs.getInt(2)));
			}
			for (Frequencies tmp : frequencies){
				System.out.println(tmp);
			}
			
			st.executeUpdate(DELETE_QUERY);
			
			
			PreparedStatement preparedStatement = cn.prepareStatement(INSERT_QUERY);
			
			for(Frequencies tmp: frequencies){
				preparedStatement.setInt(1, tmp.getLen());
				preparedStatement.setInt(2, tmp.getNum());
				preparedStatement.executeUpdate();
			}
			
			st = cn.createStatement();
			
			
			rs = st.executeQuery(SELECT_FROM_FREQ);
			while(rs.next()) {
				System.out.println(rs.getString(1)+";"+rs.getString(2));
			}
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		 catch (SQLException e) {
 			e.printStackTrace();
		}


	}
}