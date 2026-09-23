package com.college.grievance.controller;
import jakarta.servlet.*;import jakarta.servlet.http.*;import jakarta.servlet.annotation.*;import java.io.*;
@WebServlet("/logout") public class LogoutServlet extends HttpServlet{protected void doGet(HttpServletRequest q,HttpServletResponse r)throws IOException{q.getSession().invalidate();r.sendRedirect("login.jsp");}}