package com.utility;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
    private static String jdbcURL = "jdbc:mysql://localhost:3306/sample3";
    private static String jdbcUsername = "root";
    private static String jdbcPassword = "123456";

    public static java.sql.Connection getConnection() {
        java.sql.Connection connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return connection;
    }
}
