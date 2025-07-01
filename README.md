# 🛡️ User Registration System

This project is a **User Registration and Login System** built using **Spring Boot**, **Spring Security**, and **Thymeleaf**. It provides a secure and user-friendly interface for users to register, log in, and access protected resources based on their roles.

---

## ✨ Features

- ✅ User Registration with form validation  
- 🔐 Secure login using Spring Security  
- 👨‍💻 Built with Thymeleaf for dynamic HTML rendering  
- 🔄 Passwords are encrypted using BCrypt  
- ✅ Integration with MySQL (configurable)

---

## 🛠️ Tech Stack

- **Java 21**  
- **Spring Boot**  
- **Spring Security**  
- **Spring Data JPA**  
- **Thymeleaf**  
- **MySQL**  
- **Lombok**
- **Validation**  
- **Maven**

---

## 📁 Project Structure

```bash
src/
├── main/
│   ├── java/com/example/demo/
│   │   ├── controller/         # Controllers for user and auth handling
│   │   ├── entity/             # User and Role entities
│   │   ├── repo/               # JPA repositories
│   │   ├── service/            # Service classes for business logic
│   │   ├── config/             # Spring Security configuration
|   |   └── dto/                # Tranfers data between layers
│   └── resources/
│       ├── templates/          # Thymeleaf HTML pages
│       ├── static/             # CSS, images
        └── application.properties

🚀 Getting Started
Prerequisites
Java 21
Maven
MySQL (or use H2 for quick setup)
IDE (IntelliJ, Eclipse, etc.)

Clone and Run
git clone https://github.com/your-username/user-registration-springboot.git
cd user-registration-springboot

Configure Database
Update application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/dbl
spring.datasource.username=root
spring.datasource.password=

spring.jpa.hibernate.ddl-auto=update
spring.thymeleaf.cache=false
spring.security.user.name=admin
spring.security.user.password=admin

Build and Run
mvn clean install
mvn spring-boot:run
Then go to http://localhost:8080 to access the app.

Upcoming Features:
- parent login/student login sections
- email confirmation/verification
- database schema export
- deployment instructions

<img width="959" alt="image" src="https://github.com/user-attachments/assets/74f7c948-85aa-4762-9151-7922165ac65a" />

