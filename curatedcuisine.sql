CREATE DATABASE IF NOT EXISTS curatedcuisine;
USE curatedcuisine;

CREATE TABLE users(
 id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(100) NOT NULL,
 email VARCHAR(150) UNIQUE NOT NULL, password VARCHAR(255) NOT NULL,
 role ENUM('CUSTOMER','ADMIN') DEFAULT 'CUSTOMER'
);
CREATE TABLE restaurants(
 id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(120) NOT NULL,
 cuisine VARCHAR(100), address VARCHAR(255), image_url VARCHAR(500)
);
CREATE TABLE food_items(
 id INT PRIMARY KEY AUTO_INCREMENT, restaurant_id INT NOT NULL,
 name VARCHAR(120) NOT NULL, description VARCHAR(500), price DECIMAL(10,2) NOT NULL,
 image_url VARCHAR(500), FOREIGN KEY(restaurant_id) REFERENCES restaurants(id) ON DELETE CASCADE
);
CREATE TABLE cart(
 id INT PRIMARY KEY AUTO_INCREMENT, user_id INT NOT NULL, food_id INT NOT NULL,
 quantity INT NOT NULL DEFAULT 1,
 UNIQUE KEY uq_cart(user_id,food_id),
 FOREIGN KEY(user_id) REFERENCES users(id) ON DELETE CASCADE,
 FOREIGN KEY(food_id) REFERENCES food_items(id) ON DELETE CASCADE
);
CREATE TABLE orders(
 id INT PRIMARY KEY AUTO_INCREMENT, user_id INT NOT NULL,
 total DECIMAL(10,2) NOT NULL, status VARCHAR(40) DEFAULT 'PLACED',
 created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
 FOREIGN KEY(user_id) REFERENCES users(id)
);
CREATE TABLE order_items(
 id INT PRIMARY KEY AUTO_INCREMENT, order_id INT NOT NULL, food_id INT NOT NULL,
 quantity INT NOT NULL, price DECIMAL(10,2) NOT NULL,
 FOREIGN KEY(order_id) REFERENCES orders(id) ON DELETE CASCADE,
 FOREIGN KEY(food_id) REFERENCES food_items(id)
);

INSERT INTO restaurants(name,cuisine,address,image_url) VALUES
('Pizza Palace','Italian','Main Street','https://images.unsplash.com/photo-1579751626657-72bc17010498?w=800'),
('Burger Hub','American','City Center','https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=800'),
('Spice Kitchen','Indian','Market Road','https://images.unsplash.com/photo-1585937421612-70a008356fbe?w=800');

INSERT INTO food_items(restaurant_id,name,description,price,image_url) VALUES
(1,'Margherita Pizza','Classic tomato, mozzarella and basil',249,'https://images.unsplash.com/photo-1574071318508-1cdbab80d002?w=800'),
(1,'Farmhouse Pizza','Fresh vegetables and mozzarella',329,'https://images.unsplash.com/photo-1565299624946-b28f40a0ae38?w=800'),
(2,'Classic Cheeseburger','Juicy patty, cheese, lettuce and sauce',199,'https://images.unsplash.com/photo-1568901346375-23c9450c58cd?w=800'),
(2,'Crispy Chicken Burger','Crispy chicken with fresh toppings',229,'https://images.unsplash.com/photo-1606755962773-d324e0a13086?w=800'),
(3,'Paneer Butter Masala','Creamy Indian paneer curry',249,'https://images.unsplash.com/photo-1631452180519-c014fe946bc7?w=800'),
(3,'Veg Biryani','Aromatic basmati rice and vegetables',199,'https://images.unsplash.com/photo-1589302168068-964664d93dc0?w=800');
