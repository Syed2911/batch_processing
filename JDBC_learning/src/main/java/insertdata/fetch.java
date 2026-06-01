package insertdata;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class fetch {

    public static void main(String[] args) {

        try {

            // Load PostgreSQL Driver
            Class.forName("org.postgresql.Driver");

            // Database URL
            String url =
            "jdbc:postgresql://localhost:5432/jdbcdb?user=postgres&password=root123";

            // Create Connection
            Connection connection =
            DriverManager.getConnection(url);

            // SQL Query
            String sql = "select * from staff";

            // Create Statement
            Statement statement =
            connection.createStatement();

            // Execute Query
            ResultSet rs =
            statement.executeQuery(sql);

            // Heading
            System.out.println("id\tname\tmobile");

            // Fetch Data
            while (rs.next()) {

                System.out.println(
                        rs.getInt(1) + "\t" +
                        rs.getString(2) + "\t" +
                        rs.getLong(3)
                );
            }

            // Close Connections
            rs.close();
            statement.close();
            connection.close();

        }

        catch (ClassNotFoundException e) {

            e.printStackTrace();
        }

        catch (Exception e) {

            e.printStackTrace();
        }
    }
}