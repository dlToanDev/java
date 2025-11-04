package db;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/swing_login";
    private static final String USER = "root";       // user bạn tạo
    private static final String PASSWORD = "root"; // mật khẩu bạn đặt

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
