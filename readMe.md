Spring Boot, MySQL, JPA, Hibernate Rest API Tutorial
Build Restful CRUD API for a simple Movie Crud using Spring Boot, Mysql, JPA and Hibernate.

Requirements

Java - 1.8.x

Maven - 3.x.x

Mysql - 5.x.x

Steps to Setup

1. Take the clone

git clone https://github.com/Rahul16195/MovieCrud.git

2. Create Mysql database

create database movie_crud

3. Change mysql username and password as per your installation

open src/main/resources/application.properties

change spring.datasource.username and spring.datasource.password as per your mysql installation

4. Build and run the app using maven

mvn package
java -jar target/mymovie-1.0.0.jar
Alternatively, you can run the app without packaging it using -

mvn spring-boot:run
The app will start running at http://localhost:8080.

Explore Rest APIs

The app defines following CRUD APIs.

GET /api/movies

POST /api/movie

GET /api/movies/{movieId}

PUT /api/movies/{movieId}

DELETE /api/movies/{movieId}

You can test them using postman or any other rest client.
