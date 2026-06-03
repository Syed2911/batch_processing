package batchprocessing;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class insert_in_batch {
	public static void main(String[] args) {
		try {
			Class.forName("org.postgresql.Driver");
			String url = "jdbc:postgresql://localhost:5432/jdbcdb";
			String user = "postgres";
			String password = "root123";
			
			Connection connection = DriverManager.getConnection(url,user,password);
			
			String sql = "insert into students values(?,?,?,?,?)";
			PreparedStatement ps = connection.prepareStatement(sql);
			ps.setInt(1,100);
			ps.setString(2,"Syed");
			ps.setDouble(3,55.8);
			ps.setBoolean(4,false);
			ps.setDate(5,Date.valueOf("2001-05-01"));
			ps.addBatch();
			
			ps.setInt(1,101);
			ps.setString(2,"Sharmili");
			ps.setDouble(3,54.8);
			ps.setBoolean(4,true);
			ps.setDate(5,Date.valueOf("2001-04-01"));
			ps.addBatch();
			ps.executeBatch();
			System.out.println("Data executed successfully");
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
