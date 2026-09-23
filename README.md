# Student Grievance Portal — Stage 3
Full college-project foundation using Java 17, JSP, Servlets, MySQL and Tomcat 10.1.

## Added in Stage 3
- Professional responsive UI
- Student dashboard statistics
- Admin dashboard statistics
- Search by complaint ID/student/category/description
- Filter by status
- Admin remarks
- Better complaint IDs
- Separate dashboard servlets
- Role protection for admin routes
- Registration and login
- Complaint tracking

## Setup
1. Install JDK 17, Maven, MySQL 8+, and Tomcat 10.1.
2. Create database by running `database/grievance_portal.sql` in MySQL.
3. Change DB username/password in `DBConnection.java` if needed.
4. In this project folder run: `mvn clean package`
5. Copy `target/StudentGrievancePortal.war` into Tomcat's `webapps` folder.
6. Start Tomcat.
7. Open `http://localhost:8080/StudentGrievancePortal/`

Demo admin: admin@college.com / admin123
Demo student: student@college.com / student123

NOTE: Demo passwords are intentionally simple for college demonstration. For production, use password hashing and environment-based DB configuration.

## Final Stage
- Individual complaint detail page
- Student/admin access control for complaint details
- Clickable complaint IDs
- Cleaner final UI and status timeline
- Ready for college demonstration after local setup
