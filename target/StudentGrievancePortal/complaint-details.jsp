<%@ page import="com.college.grievance.model.*" %><%@ page contentType="text/html;charset=UTF-8" %><%Complaint c=(Complaint)request.getAttribute("complaint");%>
<!doctype html><html><head><title>Complaint Details</title><link rel="stylesheet" href="css/style.css"></head><body>
<nav><b>🎓 Grievance Portal</b><a href="<%=session.getAttribute("user")!=null && ((User)session.getAttribute("user")).role.equals("ADMIN")?"admin":"dashboard"%>">← Back</a></nav>
<main><div class="card details"><div class="detailtop"><div><small>Complaint ID</small><h1><%=c.code%></h1></div><span class="pill <%=c.status.replace(" ","").toLowerCase()%>"><%=c.status%></span></div>
<div class="detailgrid"><div><small>Student</small><b><%=c.studentName%></b></div><div><small>Email</small><b><%=c.studentEmail%></b></div><div><small>Category</small><b><%=c.category%></b></div><div><small>Location</small><b><%=c.location%></b></div></div>
<h3>Description</h3><p class="description"><%=c.description%></p><h3>Admin Remark</h3><p class="description"><%=c.remark==null||c.remark.isBlank()?"No remark added yet.":c.remark%></p>
<div class="timeline"><div><b>Submitted</b><span><%=c.createdAt%></span></div><div><b>Current status</b><span><%=c.status%></span></div></div>
</div></main></body></html>