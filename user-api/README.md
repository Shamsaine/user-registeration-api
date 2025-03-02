# User Registration API

This project is a simple API for managing user registrations. It provides endpoints for creating, reading, updating, and deleting users.

## Table of Contents

- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
  - [Create User](#create-user)
  - [Get All Users](#get-all-users)
  - [Get User by ID](#get-user-by-id)
  - [Update User](#update-user)
  - [Delete User](#delete-user)
- [Entities](#entities)
  - [User](#user)
- [Running the Application](#running-the-application)

## Getting Started

To get started with this project, you need to have the following installed:

- Java 17 or higher
- Maven
- An IDE (e.g., IntelliJ IDEA, Eclipse, VS Code)

## Endpoints

### Create User

- **URL:** `/api/users`
- **Method:** `POST`
- **Request Body:**

  ```json
  {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "gender": "MALE",
      "phoneNumber": "1234567890"
  }
  ```

- **Response:**

  ```json
  {
      "userId": 1,
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "gender": "MALE",
      "phoneNumber": "1234567890"
  }
  ```

### Get All Users

- **URL:** `/api/users`
- **Method:** `GET`
- **Response:**

  ```json
  [
      {
          "userId": 1,
          "firstName": "John",
          "lastName": "Doe",
          "email": "john.doe@example.com",
          "gender": "MALE",
          "phoneNumber": "1234567890"
      },
      {
          "userId": 2,
          "firstName": "Jane",
          "lastName": "Smith",
          "email": "jane.smith@example.com",
          "gender": "FEMALE",
          "phoneNumber": "0987654321"
      }
  ]
  ```

### Get User by ID

- **URL:** `/api/users/{userId}`
- **Method:** `GET`
- **Response:**

  ```json
  {
      "userId": 1,
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "gender": "MALE",
      "phoneNumber": "1234567890"
  }
  ```

### Update User

- **URL:** `/api/users/{userId}`
- **Method:** `PUT`
- **Request Body:**

  ```json
  {
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "gender": "MALE",
      "phoneNumber": "1234567890"
  }
  ```

- **Response:**

  ```json
  {
      "userId": 1,
      "firstName": "John",
      "lastName": "Doe",
      "email": "john.doe@example.com",
      "gender": "MALE",
      "phoneNumber": "1234567890"
  }
  ```

### Delete User

- **URL:** `/api/users/{userId}`
- **Method:** `DELETE`
- **Response:**

  ```json
  {
      "message": "User deleted successfully."
  }
  ```

## Entities

### User

- **Fields:**
  - `userId` (int): The unique identifier for the user.
  - `firstName` (String): The first name of the user.
  - `lastName` (String): The last name of the user.
  - `email` (String): The email address of the user.
  - `gender` (Gender): The gender of the user. Can be `MALE`, `FEMALE`, or `OTHER`.
  - `phoneNumber` (String): The phone number of the user.

## Running the Application

To run the application, use the following command:

```sh
mvn spring-boot:run
```

The application will start on `http://localhost:8080`.

You can use tools like Postman or curl to interact with the API endpoints.

## License

This project is licensed under the MIT License.
```

This documentation provides an overview of the API, including the available endpoints, request and response formats, and instructions for running the application. You can expand this documentation as needed to include more details or additional features.
