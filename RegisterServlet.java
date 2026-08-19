package com.curatedcuisine.controller;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.*; import com.curatedcuisine.dao.UserDAO; import com.curatedcuisine.model.User;
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  try{User u=new User();u.setName(req.getParameter("name"));u.setEmail(req.getParameter("email"));u.setPassword(req.getParameter("password"));new UserDAO().register(u);resp.sendRedirect("login.jsp");}catch(Exception e){throw new ServletException(e);}
 }
}