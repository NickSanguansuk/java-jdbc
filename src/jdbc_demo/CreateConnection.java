package jdbc_demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class CreateConnection {

    public static void main(String[] args) {

        // Follow this YouTube video to download and put the mysql-connector-java to the project
        // https://www.youtube.com/watch?v=e8g9eNnFpHQ&t=115s

        try {
            // loads the JDBC driver for Mysql / MariaDB
            Class.forName("com.mysql.cj.jdbc.Driver");

            // creates connection using a connection URL
            Connection conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shoestore", "root", "root");

            // crating a statement which we will run SQL
            Statement stmt = conn.createStatement();

            // run an SQL statement and capture the result set
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");

            //
            while (rs.next()) {
                System.out.println("id = " + rs.getInt("id") + ", name = " + rs.getString("firstName") + " " + rs.getString("lastName") + ", email = " + rs.getString("email"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Connection success");

    }
}
