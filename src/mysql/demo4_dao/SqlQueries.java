package mysql.demo4_dao;

public class SqlQueries {

    public final static String getUserByLastNameQuery = "SELECT * FROM users WHERE lastName = ?";
    public final static String updateUserFirstNameByIdQuery = "UPDATE users SET firstName = ? WHERE id = ?";
    public final static String deleteUserByIdQuery = "DELETE FROM users WHERE id = ?;";

}
