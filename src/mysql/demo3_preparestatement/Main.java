package mysql.demo3_preparestatement;

import mysql.demo2_createstatement.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String IP_ADDRESS = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String SCHEMA = "shoestore";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    public List<User> getUserByLastName(String lastNameValue, Integer idValue) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            // Loads the JDBC driver for Mysql / MariaDB
            //Class.forName("com.mysql.cj.jdbc.Driver");

            // Creates connection using a connection URL
            String url = "jdbc:mysql://" + IP_ADDRESS
                    + ":" + PORT
                    + "/" + SCHEMA;
            conn = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);

            // Crating a prepare statement from String sql
            String sql = "SELECT * FROM users WHERE lastName = ? and id = ?";
            System.out.println(sql);
            stmt = conn.prepareStatement(sql);

            stmt.setString(1, lastNameValue);
            stmt.setInt(2, idValue);

            // Run an SQL statement and capture the result set
            rs = stmt.executeQuery();

            // Parse ResultSet
            while (rs.next()) {
                User user = new User();

                user.setId(rs.getInt("id"));
                user.setFirstName(rs.getString("firstName"));
                user.setLastName(rs.getString("lastName"));
                user.setEmail(rs.getString("email"));
                user.setPassword(rs.getString("password"));
                user.setPhone(rs.getString("phone"));
                user.setAddress(rs.getString("address"));
                user.setCity(rs.getString("city"));
                user.setState(rs.getString("state"));
                user.setZipCode(rs.getString("zipCode"));

                users.add(user);
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

        return users;
    }

    public static void main(String[] args) {
        List<User> users = new Main().getUserByLastName("Smith", 2);

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("----------");

        System.out.println("Connection success");
    }
}
