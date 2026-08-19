# CuratedCuisine – Full Stack Food Ordering System

Tech stack: Java 17, JSP, Jakarta Servlets, JDBC, MySQL, Maven, Apache Tomcat 10.1+.

## Features
- Customer registration/login
- Restaurant listing and food menus
- Search/filter food
- Cart management
- Checkout and order history
- Admin dashboard
- Restaurant, food and order management
- MVC + DAO architecture

## Run
1. Create a MySQL database.
2. Run `database/curatedcuisine.sql`.
3. Update database credentials in `src/main/java/com/curatedcuisine/util/DBConnection.java`.
4. Run `mvn clean package`.
5. Deploy `target/CuratedCuisine.war` to Tomcat 10.1+.
6. Open `http://localhost:8080/CuratedCuisine/`.
