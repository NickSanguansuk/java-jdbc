package mysql.demo4_dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRoleDao extends AbstractDao {

    public List<UserRole> getUserRolesByLastName(String lastNameValue) {
        PreparedStatement stmt = null;
        ResultSet rs = null;

        List<UserRole> userRoles = new ArrayList<>();

        try {
            // run an SQL statement and capture the result set
            String sql = "SELECT ur.* " +
                    "FROM userroles AS ur LEFT JOIN users AS u ON ur.userId = u.id " +
                    "WHERE u.lastName = ?";
            System.out.println(sql);
            stmt = createPreparedStatement(sql);

            stmt.setString(1, lastNameValue);

            rs = stmt.executeQuery();

            // Parse result set
            while (rs.next()) {
                UserRole userRole = new UserRole();

                userRole.setId(rs.getInt("id"));
                userRole.setUserId(rs.getInt("userId"));
                userRole.setRole(rs.getString("role"));

                userRoles.add(userRole);
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

        return userRoles;
    }
}
