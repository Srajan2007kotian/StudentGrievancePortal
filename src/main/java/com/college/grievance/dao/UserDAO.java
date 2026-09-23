package com.college.grievance.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.college.grievance.model.User;
import com.college.grievance.util.DBConnection;

public class UserDAO {

    public User login(String email, String password) throws Exception {

        String q = "SELECT * FROM users WHERE email=? AND password=?";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement(q)) {

            p.setString(1, email);
            p.setString(2, password);

            ResultSet r = p.executeQuery();

            if (r.next()) {
                User u = new User();

                u.id = r.getInt("id");
                u.name = r.getString("name");
                u.email = r.getString("email");

                return u;
            }
        }

        return null;
    }

    public boolean register(String name, String email, String password) throws Exception {

        String q = "INSERT INTO users(name,email,password,role) VALUES(?,?,?,'STUDENT')";

        try (Connection c = DBConnection.getConnection();
             PreparedStatement p = c.prepareStatement(q)) {

            p.setString(1, name);
            p.setString(2, email);
            p.setString(3, password);

            return p.executeUpdate() > 0;
        }
    }
}