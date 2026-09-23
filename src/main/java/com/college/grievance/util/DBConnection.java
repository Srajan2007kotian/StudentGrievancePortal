package com.college.grievance.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("PostgreSQL JDBC Driver not found", e);
        }
    }

    public static Connection getConnection() throws SQLException {

        String databaseUrl = System.getenv("DATABASE_URL");

        if (databaseUrl != null && !databaseUrl.isBlank()) {

            if (databaseUrl.startsWith("postgresql://")) {
                databaseUrl = "jdbc:" + databaseUrl;
            }

            return DriverManager.getConnection(databaseUrl);
        }

        // Local MySQL connection
        String url =
                "jdbc:mysql://localhost:3306/grievance_portal" +
                "?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

        String user = "grievance_user";
        String password = "grievance123";

        return DriverManager.getConnection(url, user, password);
    }
}