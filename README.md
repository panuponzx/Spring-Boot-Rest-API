# Spring-Boot-Rest-API

## Description
  This project is a demo application built using Spring Boot. It serves as a REST API that provides various endpoints for interacting with a database using JPA (Java Persistence API).

## Features
  - Spring Boot framework for easy setup and configuration
  - RESTful endpoints for CRUD operations
  - Integration with JPA for database interactions
  - Unit and integration tests using Spring Boot Starter Test

## Getting Started
  **Prerequisites**
  - Java 17
  - Maven
  - 
  **Installation**
  1. Clone the repository:
      ```sh
      git clone https://github.com/panuponzx/Spring-Boot-Rest-API.git

  2. Navigate to the project directory:
      ```sh
      cd Spring-Boot-Rest-API

  3. Build the project using Maven
       ```sh
       mvn clean install

## Running the Application
  To run the application, use the following command:
          ```sh
          mvn spring-boot:run

          
** The application will start on http://localhost:8080. **

## Usage
  You can interact with the API using tools like Postman or cURL. Below are some example endpoints:
  - **GET /api/entities - Retrieve all entities**
  - **POST /api/entities - Create a new entity**
  - **PUT /api/entities/{id} - Update an existing entity**
  - **DELETE /api/entities/{id} - Delete an entity**

## License
  This project is licensed under the MIT License.
