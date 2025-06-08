# 🛍️ Product Service Application

A RESTful Product Service built with **Spring Boot**, featuring **role-based access control**, **DTO pattern**, **JUnit & Mockito testing**, **Basic Authentication**, and **Swagger** for interactive API documentation.

---

## 🚀 Features

- **Product & Category Management**
  - Add, update, delete, and view products and categories via REST APIs.
- **Role-Based Access**
  - **Admin**: Full access to manage products and categories.
  - **Seller**: Can manage only their own products.
- **Authentication**
  - Basic Authentication used to secure endpoints and manage access per user role.
- **DTO Usage**
  - Data Transfer Objects (DTOs) ensure clean API responses and prevent database entity exposure.
- **Testing**
  - Unit tests created using **JUnit** and **Mockito** to ensure business logic correctness.
- **API Documentation**
  - **Swagger** integrated for clear, interactive API testing and exploration.
- **Logging**
  - Configured logging for monitoring application activity and debugging.

---

## 🛠️ Tech Stack

- Java 17+
- Spring Boot
- Spring Security (Basic Auth)
- Spring Data JPA
- Hibernate
- H2 / MySQL (configurable)
- JUnit 5 & Mockito
- Swagger (Springfox or springdoc-openapi)
- Maven / Gradle

---

## 🔐 User Roles

| Role   | Permissions                           |
|--------|----------------------------------------|
| Admin  | Full control over products & categories |
| Seller | CRUD operations on their own products only |

---

## 🧪 Testing

- Unit testing with **JUnit 5** and **Mockito**
- Coverage includes service layer and core business logic

---

## 📒 API Documentation

- Swagger

