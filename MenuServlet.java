package com.curatedcuisine.controller;
import jakarta.servlet.*; import jakarta.servlet.http.*; import jakarta.servlet.annotation.*; import java.io.*; import com.curatedcuisine.dao.FoodDAO;
@WebServlet("/menu")
public class MenuServlet extends HttpServlet {
 protected void doGet(HttpServletRequest req,HttpServletResponse resp)throws ServletException,IOException{try{int id=Integer.parseInt(req.getParameter("restaurantId"));req.setAttribute("foods",new FoodDAO().byRestaurant(id));req.getRequestDispatcher("menu.jsp").forward(req,resp);}catch(Exception e){throw new ServletException(e);}}
}