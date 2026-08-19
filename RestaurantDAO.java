package com.curatedcuisine.dao;
import com.curatedcuisine.model.Restaurant; import com.curatedcuisine.util.DBConnection; import java.sql.*; import java.util.*;
public class RestaurantDAO {
 public List<Restaurant> findAll()throws SQLException{
  List<Restaurant> list=new ArrayList<>(); String q="SELECT * FROM restaurants ORDER BY id";
  try(Connection c=DBConnection.getConnection();PreparedStatement p=c.prepareStatement(q);ResultSet r=p.executeQuery()){while(r.next()){Restaurant x=new Restaurant();x.setId(r.getInt("id"));x.setName(r.getString("name"));x.setCuisine(r.getString("cuisine"));x.setAddress(r.getString("address"));x.setImageUrl(r.getString("image_url"));list.add(x);}} return list;
 }
}