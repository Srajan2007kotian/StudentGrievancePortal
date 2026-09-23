package com.college.grievance.model;
import java.sql.Timestamp;
public class Complaint {
 public int id; public String code,studentName,studentEmail,category,location,description,status,remark; public Timestamp createdAt,updatedAt;
}