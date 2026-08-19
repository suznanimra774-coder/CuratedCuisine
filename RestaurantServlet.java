package com.curatedcuisine.controller;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.*; import com.curatedcuisine.dao.RestaurantDAO;
@WebServlet("/restaurants")
public class RestaurantServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{try{req.setAttribute("restaurants",new RestaurantDAO().findAll());req.getRequestDispatcher("restaurants.jsp").forward(req,resp);}catch(Exception e){throw new ServletException(e);}}
}