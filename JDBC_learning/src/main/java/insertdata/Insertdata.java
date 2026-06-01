package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Insertdata {

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

            // Step 3 - Insert Data into staff table
            String sql =
                    "insert into staff values(101,'Dhanush',7894561230)";

            Statement statement =
                    connection.createStatement();

            statement.execute(sql);

            System.out.println("Data inserted successfully");

            // Step 4 - Close Connection
            connection.close();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}