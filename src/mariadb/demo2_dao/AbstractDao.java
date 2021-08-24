package mariadb.demo2_dao;

import java.sql.*;

public class AbstractDao {
    // Data
    private final Driver DRIVER = new org.mariadb.jdbc.Driver();
    private final String URL = "jdbc:mariadb://127.0.0.1:3306/shoestore";
    private final String DB_USERNAME = "root";
    private final String DB_PASSWORD = "root";

    protected Connection conn = null;
    protected PreparedStatement ps = null;
    protected ResultSet rs = null;

    // Constructors
    public AbstractDao() {
    }

    // Getters and Setters

    // Methods
    public void connect() {
        if (this.conn == null) {
            try {
                DriverManager.registerDriver(this.DRIVER);
                this.conn = DriverManager.getConnection(this.URL, this.DB_USERNAME, this.DB_PASSWORD);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void dispose() {
        try {
            if (this.rs != null) {
                this.rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (this.ps != null) {
                    this.ps.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (this.conn != null) {
                        this.conn.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }


}
