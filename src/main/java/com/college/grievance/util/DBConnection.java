package com.college.grievance.util;

import java.sql.*;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/grievance_portal?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String USER = "grievance_user";

    private static final String PASSWORD = "grievance123";

    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}