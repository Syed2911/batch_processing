package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class deletedata {

    public static void main(String[] args) {

        try {

            // Step 1 - Load Driver
            Class.forName("org.postgresql.Driver");

            // Step 2 - Establish Connection
            String url = "jdbc:postgresql://localhost:5432/jdbcdb";
            String user = "postgres";
            String password = "root123";

            Connection connection =
                    DriverManager.getConnection(url, user, password);

            // Step 3 - Delete Query
            String sql =
                    "delete from staff where id=101";

            Statement statement =
                    connection.createStatement();

            statement.execute(sql);

            System.out.println("Data deleted successfully");

            // Step 4 - Close Connection
            connection.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}