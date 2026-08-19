package com.curatedcuisine.controller;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.*; import com.curatedcuisine.dao.UserDAO; import com.curatedcuisine.model.User;
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
 protected void doPost(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{
  try{User u=new UserDAO().login(req.getParameter("email"),req.getParameter("password"));if(u!=null){req.getSession().setAttribute("user",u);resp.sendRedirect("restaurants");}else{req.setAttribute("error","Invalid email or password");req.getRequestDispatcher("login.jsp").forward(req,resp);}}catch(Exception e){throw new ServletException(e);}
 }
}