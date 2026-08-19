package com.curatedcuisine.dao;
import com.curatedcuisine.model.User; import com.curatedcuisine.util.DBConnection; import java.sql.*;
public class UserDAO {
 public boolean register(User u)throws SQLException{
  String q="INSERT INTO users(name,email,password,role) VALUES(?,?,?,'CUSTOMER')";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q)){p.setString(1,u.getName());p.setString(2,u.getEmail());p.setString(3,u.getPassword());return p.executeUpdate()>0;}
 }
 public User login(String email,String password)throws SQLException{
  String q="SELECT * FROM users WHERE email=? AND password=?";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q)){p.setString(1,email);p.setString(2,password);ResultSet r=p.executeQuery();if(r.next())return new User(r.getInt("id"),r.getString("name"),r.getString("email"),r.getString("password"),r.getString("role"));} return null;
 }
}