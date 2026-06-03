package CallProcedure;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

public class insertdata {
	public static void main(String[] args)  {
		try {
			Class.forName("org.postgresql.Driver");
			String url ="jdbc:postgresql://localhost:5432/jdbcdb?user=postgres&password=root123";
			Connection connection = DriverManager.getConnection(url);
			String sql = "call get_bill(?)";
			CallableStatement cs = connection.prepareCall(sql);
			cs.setInt(1,0);
			cs.registerOutParameter(1, Types.INTEGER);
			cs.execute();
			System.out.println("Bill: "+cs.getInt(1));
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
