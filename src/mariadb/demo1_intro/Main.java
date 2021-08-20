package mariadb.demo1_intro;

import java.sql.*;

public class Main {

    public static void main(String[] args) {

        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            Class.forName("org.mariadb.jdbc.Driver");
            String url = "jdbc:mariadb://localhost:3306/shoestore";
            final String USER = "root";
            final String PASS = "root";
            conn = DriverManager.getConnection(url, USER, PASS);

            String selectSQL = "Select * FROM users";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(selectSQL);
            while (rs.next()) {
                String name = rs.getString("firstName");
                String email = rs.getString("email");
                System.out.println(name + " | " + email);
            }
        } catch (SQLException | ClassNotFoundException e) {
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


    }
}
