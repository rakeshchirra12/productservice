# Product Service

## Overview
This project is a Spring Boot application that provides a product management service. It includes functionalities for creating, reading, updating, and deleting products. The project uses Spring Boot, Maven, and SQL.

## Project Structure
- `src/main/java/com/rakesh/authmodule/security/Test.java`: Contains a test class for string manipulation.
- `src/main/java/com/product/productservice/service/SelfProductService.java`: Implements the `ProductService` interface to provide product-related operations.
- `src/main/java/com/product/productservice/model/BaseModel.java`: Defines a base model class with common fields for all entities.
- `src/main/java/com/product/productservice/controller/ProductController.java`: REST controller for handling product-related HTTP requests.

## Technologies Used
- Java
- Spring Boot
- Maven
- SQL

## Services

### Product Service
Provides CRUD operations for products.

#### Endpoints
- **GET /products/{id}**: Retrieve a product by its ID.
- **GET /products/**: Retrieve all products with pagination and sorting.
- **POST /products**: Create a new product.
- **PATCH /products/{id}**: Partially update an existing product.
- **PUT /products/{id}**: Replace an existing product.
- **DELETE /products/{id}**: Delete a product by its ID.

### Authentication Commons
Utility class for validating user tokens and roles.

## Running the Application
1. Clone the repository.
2. Navigate to the project directory.
3. Run `mvn clean install` to build the project.
4. Run `mvn spring-boot:run` to start the application.

## License
This project is licensed under the MIT License.
