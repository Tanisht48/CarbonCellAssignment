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
  ```json
  {
  "name": "string",
  "email": "yourMail",
  "password": "securepassword",
   "about":"Description"
  }

- **Response Body:**
    - Success message if the user is registered successfully, including the ID of the created user.
    - Error message if there's an internal server error during user creation.

### User Login

- **URL:** `auth/login`
- **Method:** `POST`
- **Description:** Logs in an existing user.
- **Request Body:**
  - JSON object representing the user's credentials.
  - Includes email and password.

  ```json
  {
  "email": "user@example.com",
  "password": "securepassword"
  }

### Get All Users

- **URL:** `/home/users`
- **Method:** `GET`
- **Description:** Retrieves a list of all users.
- **Authorization:** None required.

- **Response Body:**
  - Success Response:
    - Status Code: `200 OK`
    - JSON array containing the details of all users.

  ```json
    [
  {
    "userId": 1,
    "username": "user1",
    "email": "user1@example.com"
  },
  {
    "userId": 2,
    "username": "user2",
    "email": "user2@example.com"
  },
  
    ]

### Get Current User

- **URL:** `/home/current-user`
- **Method:** `GET`
- **Description:** Retrieves the username of the currently logged-in user.
- **Authorization:** None required.

- **Response Body:**
  - Success Response:
    - Status Code: `200 OK`
    - String containing the username of the currently logged-in user.

## Get API Entries

- **URL:** `/home/api/entries`
- **Method:** `GET`
- **Description:** Retrieves API entries based on category and limit.
- **Authorization:** Requires user to be authenticated with the role 'USER'.

- **Query Parameters:**
  - `category` (optional): Specifies the category of entries to retrieve.
  - `limit` (default: 10): Specifies the maximum number of entries to retrieve.

- **Response Body:**
  - Success Response:
    - Status Code: `200 OK`
    - JSON object containing API entries.

  ```json
  {
  "count": 4,
  "entries": [
    {
      "API": "AdoptAPet",
      "Description": "Resource to help get pets adopted",
      "Auth": "apiKey",
      "HTTPS": true,
      "Cors": "yes",
      "Link": "https://www.adoptapet.com/public/apis/pet_list.html",
      "Category": "Animals"
    },
    {
      "API": "Axolotl",
      "Description": "Collection of axolotl pictures and facts",
      "Auth": "",
      "HTTPS": true,
      "Cors": "no",
      "Link": "https://theaxolotlapi.netlify.app/",
      "Category": "Animals"
    },
    {
      "API": "Cat Facts",
      "Description": "Daily cat facts",
      "Auth": "",
      "HTTPS": true,
      "Cors": "no",
      "Link": "https://alexwohlbruck.github.io/cat-facts/",
      "Category": "Animals"
    },
    {
      "API": "Cataas",
      "Description": "Cat as a service (cats pictures and gifs)",
      "Auth": "",
      "HTTPS": true,
      "Cors": "no",
      "Link": "https://cataas.com/",
      "Category": "Animals"
     }
   ]
  }



## Swagger Support for API Documentation

The project includes Swagger support for API documentation. Swagger is a powerful tool that provides interactive documentation for RESTful APIs, enabling developers to explore and test endpoints easily. By integrating Swagger into your project, you can enhance the usability and understanding of your API, making it easier for developers to integrate with your system.

### Key Benefits of Swagger:
- **Interactive Documentation:** Swagger generates interactive documentation that allows developers to explore and test endpoints directly from the documentation interface.
- **Ease of Integration:** Developers can easily understand and integrate with your API by referring to the comprehensive documentation provided by Swagger.
- **Consistency:** Swagger ensures that the API documentation remains consistent with the actual implementation, reducing the chances of discrepancies.
- **Time-Saving:** With Swagger, developers can quickly understand the API structure and functionalities, saving time on integration and troubleshooting.

### Swagger Configuration

The Swagger configuration (`OpenApiConfig` class) provides support for interactive documentation of RESTful APIs using Swagger. It includes:

- **Info:** Provides general information about the API, such as contact details, description, title, version, license, and terms of service.
- **Servers:** Specifies the servers where the API is hosted, allowing developers to interact with different environments.
- **Security:** Defines security requirements for accessing the API. In this case, it requires bearer token authentication.

### Authentication Bearer Token

The `bearerAuth` security scheme is defined for JWT (JSON Web Token) authentication:
- **Description:** Indicates the type of authentication, which is JWT.
- **Scheme:** Specifies the authentication scheme as "bearer", requiring clients to present a bearer token.
- **Type:** Specifies the type of security scheme as HTTP.
- **Bearer Format:** Defines the format of the bearer token as "JWT".
- **In:** Specifies the location of the bearer token in the HTTP request headers.


## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/Tanisht48/CarbonCellAssignment.git
   ```

2. Navigate to the project directory:

   ```bash
   cd CarbonCellAssignment
   ```

3. Build the project using Maven:

   ```bash
   mvn clean install
   ```

4. Run the application:

   ```bash
   mvn spring-boot:run
   ```

## Database Setup

To set up the database for the WishlistManagement application, follow these steps:

1. Open the `application.properties` file in the project's `src/main/resources` directory.

2. Configure the datasource properties according to your MySQL database setup:
   ```
   spring.datasource.url=jdbc:mysql://localhost:3306/<Your Database Name>?autoReconnect=true&useSSL=false&createDatabaseIfNotExist=true
   spring.datasource.username=your_database_username
   spring.datasource.password=your_database_password
   spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
   spring.jpa.hibernate.ddl-auto=update
   ```

   Replace `your_database_username` and `your_database_password` with your MySQL database credentials.

3. Optionally, configure Hibernate properties for SQL logging:
   ```
   spring.jpa.properties.hibernate.show_sql=true
   spring.jpa.properties.hibernate.use_sql_comments=true
   spring.jpa.properties.hibernate.format_sql=true
   ```

   These properties enable SQL logging in the console for debugging purposes.


## Accessing the Application

You can access the application through your web browser by navigating to `http://localhost:8080`.

## Custom Port Configuration

If you need to define your own port for accessing the application, you can do so by configuring it in the `application.properties` file. Simply specify the desired port number in the configuration file, and the application will listen on that port upon startup.

Example:
```properties
server.port=9000
```
## Contributing

Contributions are welcome! Please feel free to submit pull requests or open issues for any improvements or features you'd like to see.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.