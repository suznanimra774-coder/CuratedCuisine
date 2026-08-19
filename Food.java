package com.curatedcuisine.model;
public class Food {
 private int id,restaurantId; private String name,description,imageUrl; private double price;
 public int getId(){return id;} public void setId(int v){id=v;}
 public int getRestaurantId(){return restaurantId;} public void setRestaurantId(int v){restaurantId=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;}
 public double getPrice(){return price;} public void setPrice(double v){price=v;}
 public String getImageUrl(){return imageUrl;} public void setImageUrl(String v){imageUrl=v;}
}