package mysql.demo4_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao {

    public List<User> getUsersByLastName(String lastNameValue) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            // run an SQL statement and capture the result set
            //String sql = "SELECT * FROM users WHERE lastName = ?";
            String sql = SqlQueries.getUserByLastNameQuery;
            System.out.println(sql);
            stmt = createPreparedStatement(sql);

            stmt.setString(1, lastNameValue);

            rs = stmt.executeQuery();

            // Parse result set
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
                    //closeConnection();
                }
            }
        }

        return users;
    }

    public void updateUserFirstNameById(String firstNameValue, Integer idValue) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            // run an SQL statement and capture the result set
            //String sql = "UPDATE users SET firstName = ? WHERE id = ?";
            String sql = SqlQueries.updateUserFirstNameByIdQuery;
            System.out.println(sql);

            stmt = createPreparedStatement(sql);

            stmt.setString(1, firstNameValue);
            stmt.setInt(2, idValue);

            int updatedRows = stmt.executeUpdate();
            System.out.println("Rows updated = " + updatedRows);

            //rs = stmt.executeQuery();

            // Parse result set
            //while (rs.next()) {
            //    User user = new User();
            //
            //    user.setId(rs.getInt("id"));
            //    user.setFirstName(rs.getString("firstName"));
            //    user.setLastName(rs.getString("lastName"));
            //    user.setEmail(rs.getString("email"));
            //    user.setPassword(rs.getString("password"));
            //    user.setPhone(rs.getString("phone"));
            //    user.setAddress(rs.getString("address"));
            //    user.setCity(rs.getString("city"));
            //    user.setState(rs.getString("state"));
            //    user.setZipCode(rs.getString("zipCode"));
            //
            //    users.add(user);
            //}

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
                    //closeConnection();
                }
            }
        }

        //return users;
    }

    public void insertUser() {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            // run an SQL statement and capture the result set
            String sql = "INSERT INTO `users` (`firstName`, `lastName`, `email`, `password`, `phone`, `address`, `city`, `state`, `zipCode`) VALUES ('Wasin2', 'Sanguansuk2', 'wasin2.sanguansuk2@gmail.com', '123456', '(773) 999-8888', '1280 N Milwaukee Ave Apt 1101', 'Chicago', 'IL', '60642');";
            System.out.println(sql);

            stmt = createPreparedStatement(sql);

            //stmt.setString(1, firstNameValue);
            //stmt.setInt(2, idValue);

            int updatedRows = stmt.executeUpdate();
            System.out.println("Rows updated = " + updatedRows);

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
                    //closeConnection();
                }
            }
        }

        //return users;
    }

    public void deleteUserById(Integer idValue) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<User> users = new ArrayList<>();

        try {
            // run an SQL statement and capture the result set
            //String sql = "DELETE FROM users WHERE id = ?;";
            String sql = SqlQueries.deleteUserByIdQuery;
            System.out.println(sql);

            stmt = createPreparedStatement(sql);

            stmt.setInt(1, idValue);
            System.out.println(sql);

            int rowsAffected = stmt.executeUpdate();
            System.out.println("Rows affected = " + rowsAffected);

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
                    //closeConnection();
                }
            }
        }

        //return users;
    }

}
