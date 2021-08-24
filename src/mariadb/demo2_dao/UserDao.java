package mariadb.demo2_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao extends AbstractDao {

    public List<User> getUsersByLastName(String lastNameValue) {

        List<User> users = new ArrayList<>();

        try {
            this.connect();

            String sql = "SELECT * FROM users WHERE lastName = ?";

            this.ps = this.conn.prepareStatement(sql);

            this.ps.setString(1, lastNameValue);

            this.rs = this.ps.executeQuery();

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
            this.dispose();
        }

        return users;
    }

}
