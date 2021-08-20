package mysql.demo4_dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AbstractDao {
    // Data
    private static final String IP_ADDRESS = "127.0.0.1";
    private static final String PORT = "3306";
    private static final String SCHEMA = "shoestore";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "root";

    private Connection connection;

    // Constructors
    public AbstractDao() {
        this.createConnection();
    }

    // Methods
    public void createConnection() {
        if (this.connection == null) {
            String url = "jdbc:mysql://" + IP_ADDRESS
                    + ":" + PORT
                    + "/" + SCHEMA;
            try {
                this.connection = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void closeConnection() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public PreparedStatement createPreparedStatement(String sql) throws SQLException {

        return this.connection.prepareStatement(sql);
    }

}
