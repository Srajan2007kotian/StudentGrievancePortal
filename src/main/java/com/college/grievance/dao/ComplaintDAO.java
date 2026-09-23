package com.college.grievance.dao;

import com.college.grievance.model.Complaint;
import com.college.grievance.util.DBConnection;
import java.sql.*;
import java.util.*;

public class ComplaintDAO {

    private Complaint map(ResultSet r) throws Exception {
        Complaint x = new Complaint();
        x.id = r.getInt("id");
        x.code = r.getString("complaint_code");
        x.studentName = r.getString("student_name");
        x.studentEmail = r.getString("student_email");
        x.category = r.getString("category");
        x.location = r.getString("location");
        x.description = r.getString("description");
        x.status = r.getString("status");
        x.remark = r.getString("admin_remark");
        x.createdAt = r.getTimestamp("created_at");
        x.updatedAt = r.getTimestamp("updated_at");
        return x;
    }

    public String add(Complaint x) throws Exception {
        String code = "CMP" + System.currentTimeMillis();

        String q = "INSERT INTO complaints(complaint_code,student_name,student_email,category,location,description) VALUES(?,?,?,?,?,?)";

        try (
            Connection c = DBConnection.getConnection();
            PreparedStatement p = c.prepareStatement(q)
        ) {
            p.setString(1, code);
            p.setString(2, x.studentName);
            p.setString(3, x.studentEmail);
            p.setString(4, x.category);
            p.setString(5, x.location);
            p.setString(6, x.description);
            p.executeUpdate();
        }

        return code;
    }

    public List<Complaint> byEmail(String email) throws Exception {
        return list(
            "SELECT * FROM complaints WHERE student_email=? ORDER BY created_at DESC",
            email
        );
    }

    public List<Complaint> all(String search, String status) throws Exception {
        StringBuilder q = new StringBuilder(
            "SELECT * FROM complaints WHERE 1=1"
        );

        List<Object> a = new ArrayList<>();

        if (search != null && !search.isBlank()) {
            q.append(
                " AND (complaint_code LIKE ? OR student_name LIKE ? OR category LIKE ? OR description LIKE ?)"
            );

            String s = "%" + search + "%";

            for (int i = 0; i < 4; i++) {
                a.add(s);
            }
        }

        if (status != null && !status.isBlank()) {
            q.append(" AND status=?");
            a.add(status);
        }

        q.append(" ORDER BY created_at DESC");

        try (
            Connection c = DBConnection.getConnection();
            PreparedStatement p = c.prepareStatement(q.toString())
        ) {
            for (int i = 0; i < a.size(); i++) {
                p.setObject(i + 1, a.get(i));
            }

            ResultSet r = p.executeQuery();

            List<Complaint> out = new ArrayList<>();

            while (r.next()) {
                out.add(map(r));
            }

            return out;
        }
    }

    private List<Complaint> list(String q, String email) throws Exception {
        try (
            Connection c = DBConnection.getConnection();
            PreparedStatement p = c.prepareStatement(q)
        ) {
            p.setString(1, email);

            ResultSet r = p.executeQuery();

            List<Complaint> o = new ArrayList<>();

            while (r.next()) {
                o.add(map(r));
            }

            return o;
        }
    }

    public Complaint byId(int id) throws Exception {
        String q = "SELECT * FROM complaints WHERE id=?";

        try (
            Connection c = DBConnection.getConnection();
            PreparedStatement p = c.prepareStatement(q)
        ) {
            p.setInt(1, id);

            ResultSet r = p.executeQuery();

            return r.next() ? map(r) : null;
        }
    }

    public void updateStatus(int id, String status, String remark) throws Exception {
        String q = "UPDATE complaints SET status=?,admin_remark=? WHERE id=?";

        try (
            Connection c = DBConnection.getConnection();
            PreparedStatement p = c.prepareStatement(q)
        ) {
            p.setString(1, status);
            p.setString(2, remark);
            p.setInt(3, id);

            p.executeUpdate();
        }
    }

    public int count(String s) throws Exception {
        String q = "SELECT COUNT(*) FROM complaints"
                + (s == null ? "" : " WHERE status=?");

        try (
            Connection c = DBConnection.getConnection();
            PreparedStatement p = c.prepareStatement(q)
        ) {
            if (s != null) {
                p.setString(1, s);
            }

            ResultSet r = p.executeQuery();
            r.next();

            return r.getInt(1);
        }
    }
}