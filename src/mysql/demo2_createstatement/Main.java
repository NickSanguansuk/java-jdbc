package mysql.demo2_createstatement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public List<User> getAllUsers() {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            // Loads the JDBC driver for Mysql / MariaDB
            //Class.forName("com.mysql.cj.jdbc.Driver");

            // Creates connection using a connection URL
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shoestore", "root", "root");

            // Crating a statement which we will run SQL
            stmt = conn.createStatement();

            // Run an SQL statement and capture the result set
            rs = stmt.executeQuery("SELECT * FROM users");

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

    public List<User> getUserById(Integer idValue) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            // Loads the JDBC driver for Mysql / MariaDB
            //Class.forName("com.mysql.cj.jdbc.Driver");

            // Creates connection using a connection URL
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shoestore", "root", "root");

            // Crating a statement which we will run SQL
            stmt = conn.createStatement();

            // Run an SQL statement and capture the result set
            rs = stmt.executeQuery("SELECT * FROM users WHERE id = " + idValue);

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

    public List<User> getUserByLastName(String lastNameValue) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            // Loads the JDBC driver for Mysql / MariaDB
            //Class.forName("com.mysql.cj.jdbc.Driver");

            // Creates connection using a connection URL
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/shoestore", "root", "root");

            // Crating a statement which we will run SQL
            stmt = conn.createStatement();

            // Run an SQL statement and capture the result set
            rs = stmt.executeQuery("SELECT * FROM users WHERE lastName = \'" + lastNameValue + "\'");

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
        List<User> users = new Main().getAllUsers();

        for (User user : users) {
            System.out.println(user);
        }

        System.out.println("----------");

        List<User> users2 = new Main().getUserById(2);

        for (User user : users2) {
            System.out.println(user);
        }

        System.out.println("----------");

        List<User> users3 = new Main().getUserByLastName("Sanguansuk");

        for (User user : users3) {
            System.out.println(user);
        }

        System.out.println("----------");

        System.out.println("Connection success");
    }
}
