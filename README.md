<h1 align="center">UserManagement With Jwt Authentication</h1>

<p align="center">
    <a href="https://www.java.com/" target="_blank">
        <img src="https://img.shields.io/badge/Java-17-red" alt="Java 17">
    </a>
    <a href="https://maven.apache.org/" target="_blank">
        <img src="https://img.shields.io/badge/Maven-3.8.1-blue" alt="Maven 3.8.1">
    </a>
    <a href="https://spring.io/projects/spring-boot" target="_blank">
        <img src="https://img.shields.io/badge/Spring Boot-3.2.2-brightgreen" alt="Spring Boot 3.2.2">
    </a>
   <a href="https://spring.io/projects/spring-security" target="_blank">
    <img src="https://img.shields.io/badge/Spring Security-6.2.1-brightgreen" alt="Spring Security Latest">
</a>

</p>

<hr>

## Dependencies

- [Spring Boot Starter Data JPA](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-data-jpa): Provides support for Spring Data JPA, enabling easy interaction with databases using JPA.
- [Spring Boot Starter Validation](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-validation): Includes validation support for Spring MVC applications.
- [Spring Boot Starter Web](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-web): Provides basic web support, including embedded Tomcat server and Spring MVC.
- [MySQL Connector/J](https://mvnrepository.com/artifact/com.mysql/mysql-connector-j): JDBC driver for connecting to MySQL databases.
- [Lombok](https://mvnrepository.com/artifact/org.projectlombok/lombok): Reduces boilerplate code by providing annotations to generate getters, setters, constructors, and more.
- [Spring Boot Starter Test](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-test): Includes dependencies for testing Spring Boot applications.
- [Spring Boot Starter Security](https://mvnrepository.com/artifact/org.springframework.boot/spring-boot-starter-security): Provides security features for Spring Boot applications, including authentication and authorization.
- [Springdoc OpenAPI Starter WebMVC UI](https://mvnrepository.com/artifact/org.springdoc/springdoc-openapi-starter-webmvc-ui): Integrates OpenAPI documentation into Spring Boot applications.
- [JJWT API](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-api/0.11.5): JSON Web Token implementation for Java.
- [JJWT Implementation](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-impl/0.11.5): Implementation of JSON Web Token for Java runtime.
- [JJWT Jackson](https://mvnrepository.com/artifact/io.jsonwebtoken/jjwt-jackson/0.11.5): JSON Web Token Jackson support for Java runtime.

## Enpoints

### Register a New User

- **URL:** `/auth/create-user`
- **Method:** `POST`
- **Description:** Registers a new user.
- **Request Body:**
    - JSON object representing the user to be registered.
    - Includes details such as username, email, password, etc.
- **Response Body:**
    - Success message if the user is registered successfully, including the ID of the created user.
    - Error message if there's an internal server error during user creation.