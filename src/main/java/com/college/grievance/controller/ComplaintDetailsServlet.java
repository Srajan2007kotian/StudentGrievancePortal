package com.college.grievance.controller;
import jakarta.servlet.*;import jakarta.servlet.http.*;import jakarta.servlet.annotation.*;import com.college.grievance.dao.ComplaintDAO;import com.college.grievance.model.*;import java.io.*;
@WebServlet("/complaint-details")
public class ComplaintDetailsServlet extends HttpServlet{
 protected void doGet(HttpServletRequest q,HttpServletResponse r)throws ServletException,IOException{
  try{
   User u=(User)q.getSession().getAttribute("user"); if(u==null){r.sendRedirect("login.jsp");return;}
   int id=Integer.parseInt(q.getParameter("id"));
   Complaint c=new ComplaintDAO().byId(id);
   if(c==null){r.sendError(404);return;}
   if(!"ADMIN".equals(u.role) && !u.email.equals(c.studentEmail)){r.sendError(403);return;}
   q.setAttribute("complaint",c); q.getRequestDispatcher("complaint-details.jsp").forward(q,r);
  }catch(Exception e){throw new ServletException(e);}
 }
}