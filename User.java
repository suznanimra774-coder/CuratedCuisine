package com.curatedcuisine.model;
public class User {
 private int id; private String name,email,password,role;
 public User() {}
 public User(int id,String name,String email,String password,String role){this.id=id;this.name=name;this.email=email;this.password=password;this.role=role;}
 public int getId(){return id;} public void setId(int v){id=v;}
 public String getName(){return name;} public void setName(String v){name=v;}
 public String getEmail(){return email;} public void setEmail(String v){email=v;}
 public String getPassword(){return password;} public void setPassword(String v){password=v;}
 public String getRole(){return role;} public void setRole(String v){role=v;}
}