CREATE DATABASE IF NOT EXISTS grievance_portal;
USE grievance_portal;

CREATE TABLE IF NOT EXISTS users(
 id INT PRIMARY KEY AUTO_INCREMENT,
 name VARCHAR(100) NOT NULL,
 email VARCHAR(120) UNIQUE NOT NULL,
 password VARCHAR(255) NOT NULL,
 role ENUM('STUDENT','ADMIN') DEFAULT 'STUDENT'
);

CREATE TABLE IF NOT EXISTS complaints(
 id INT PRIMARY KEY AUTO_INCREMENT,
 complaint_code VARCHAR(30) UNIQUE NOT NULL,
 student_name VARCHAR(100) NOT NULL,
 student_email VARCHAR(120),
 category VARCHAR(80) NOT NULL,
 location VARCHAR(120),
 description TEXT NOT NULL,
 status ENUM('Pending','In Progress','Resolved') DEFAULT 'Pending',
 admin_remark VARCHAR(500),
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
);

INSERT IGNORE INTO users(name,email,password,role) VALUES
('System Admin','admin@college.com','admin123','ADMIN'),
('Demo Student','student@college.com','student123','STUDENT');

INSERT IGNORE INTO complaints(complaint_code,student_name,student_email,category,location,description,status,admin_remark) VALUES
('CMP1001','Rahul Sharma','student@college.com','Computer Lab','Lab 2','Three computers are not working.','Pending',''),
('CMP1002','Aisha Khan','student@college.com','Wi-Fi / Internet','Block A','Wi-Fi connection is unavailable.','In Progress','Network team notified.'),
('CMP1003','Neha Patil','student@college.com','Classroom','Room 204','Projector is not working.','Resolved','Projector cable replaced.');

-- For a real deployment, replace demo passwords with hashed passwords and move DB credentials to environment/configuration.
