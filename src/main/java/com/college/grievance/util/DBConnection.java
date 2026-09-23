package com.college.grievance.util;

import java.net.URI;
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

            try {
                URI uri = new URI(databaseUrl);

                String host = uri.getHost();
                int port = uri.getPort();

                if (port == -1) {
                    port = 5432;
                }

                String database = uri.getPath();

                String userInfo = uri.getUserInfo();
                String username = userInfo.substring(0, userInfo.indexOf(':'));
                String password = userInfo.substring(userInfo.indexOf(':') + 1);

                String jdbcUrl =
                        "jdbc:postgresql://" +
                        host + ":" + port + database;

                return DriverManager.getConnection(
                        jdbcUrl,
                        username,
                        password
                );

            } catch (Exception e) {
                throw new SQLException(
                        "Unable to connect to PostgreSQL database",
                        e
                );
            }
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