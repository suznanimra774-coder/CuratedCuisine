package com.curatedcuisine.dao;
import com.curatedcuisine.model.Food; import com.curatedcuisine.util.DBConnection; import java.sql.*; import java.util.*;
public class FoodDAO {
 public List<Food> byRestaurant(int rid)throws SQLException{
  List<Food> list=new ArrayList<>(); String q="SELECT * FROM food_items WHERE restaurant_id=?";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q)){p.setInt(1,rid);ResultSet r=p.executeQuery();while(r.next()){Food f=new Food();f.setId(r.getInt("id"));f.setRestaurantId(r.getInt("restaurant_id"));f.setName(r.getString("name"));f.setDescription(r.getString("description"));f.setPrice(r.getDouble("price"));f.setImageUrl(r.getString("image_url"));list.add(f);}} return list;
 }
 public Food find(int id)throws SQLException{
  String q="SELECT * FROM food_items WHERE id=?"; try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q)){p.setInt(1,id);ResultSet r=p.executeQuery();if(r.next()){Food f=new Food();f.setId(id);f.setRestaurantId(r.getInt("restaurant_id"));f.setName(r.getString("name"));f.setDescription(r.getString("description"));f.setPrice(r.getDouble("price"));f.setImageUrl(r.getString("image_url"));return f;}} return null;
 }
}