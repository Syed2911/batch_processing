package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class createtable {

    public static void main(String[] args) {

        try {

            // Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // Database Connection
            String url =
                "jdbc:postgresql://localhost:5432/jdbcdb?user=postgres&password=root123";

            Connection connection =
                DriverManager.getConnection(url);

            // Create Table Query
            String sql = "create table staff ("
                    + "id int primary key, "
                    + "name varchar(50), "
                    + "phone bigint"
                    + ")";

            // Create Statement
            Statement statement =
                connection.createStatement();

            // Execute Query
            statement.execute(sql);

            System.out.println("Table created successfully");

            // Close Connection
            connection.close();

        }
        catch (ClassNotFoundException e) {

            e.printStackTrace();

        }
        catch (SQLException e) {

            e.printStackTrace();

        }
    }
}