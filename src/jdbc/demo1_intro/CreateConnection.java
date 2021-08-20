package jdbc.demo1_intro;

import java.sql.*;

public class CreateConnection {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            // Loads the JDBC driver for Mysql / MariaDB
            Class.forName("com.mysql.cj.jdbc.Driver");
            //Class.forName("org.mariadb.jdbc.Driver");

            // Creates connection using a connection URL
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shoestore", "root", "root");
            //conn = DriverManager.getConnection(
            //        "jdbc:mariadb://localhost:3306/shoestore", "root", "root");

            // Crating a statement which we will run SQL
            stmt = conn.createStatement();

            // Run an SQL statement and capture the result set
            rs = stmt.executeQuery("SELECT * FROM users");

            // Printing
            while (rs.next()) {
                System.out.println("id = " + rs.getInt("id") + ", name = " + rs.getString("firstName") + " " + rs.getString("lastName") + ", email = " + rs.getString("email"));
            }

            rs = stmt.executeQuery("SELECT * FROM userroles");

            // Printing
            while (rs.next()) {
                System.out.println("id = " + rs.getInt("id") + ", userId = " + rs.getInt("userId") + ", role = " + rs.getString("role"));
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) {
                    rs.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (stmt != null) {
                        stmt.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (conn != null) {
                            conn.close();
                        }
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        System.out.println("End of main()");
    }
}
