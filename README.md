# 🚀 Bridgeify — Enterprise Job Portal Platform

<div align="center">

![Java](https://img.shields.io/badge/Java-17-orange.svg)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.7-brightgreen.svg)
![Spring Security](https://img.shields.io/badge/Spring%20Security-6.0-red.svg)
![MySQL](https://img.shields.io/badge/MySQL-8.0-blue.svg)
![Thymeleaf](https://img.shields.io/badge/Thymeleaf-3.0-green.svg)
![Bootstrap](https://img.shields.io/badge/Bootstrap-5.3-purple.svg)

**Bridgeify** is an **enterprise-grade, full-stack job portal platform** built with **Spring Boot** and **Java 17**, designed to seamlessly connect recruiters and job seekers through a secure, scalable, and feature-rich web application.

🔐 Role-based access • 🔎 Advanced search • 📄 Secure file uploads • 📊 Recruiter analytics

</div>

---

## 📌 Overview

**Bridgeify** is a production-ready job portal that follows **modern enterprise software practices** such as layered architecture, strong security controls, and scalable database design.

The platform supports **two primary roles**:

* **Job Seekers** — discover, save, and apply to jobs
* **Recruiters** — post jobs, manage applications, and analyze candidate interest

Built with **Spring Boot 3.x**, **Spring Security**, and **MySQL**, Bridgeify emphasizes:

* Clean separation of concerns
* Secure authentication & authorization
* Optimized data access using JPA
* Server-side rendering using Thymeleaf

---

## ✨ Features

### 👤 Job Seeker Capabilities

* 🔍 Advanced multi-filter job search (location, job type, remote, date)
* 📄 Resume upload & secure download
* 🖼️ Profile photo management
* 📌 Save jobs for later
* 📨 One-click job applications with Resume
* 📊 Application tracking

### 🧑‍💼 Recruiter Capabilities

* 📝 Create, edit, and manage job postings
* 👥 View candidate lists per job
* 📈 Job-level application analytics
* 🏢 Company & location association
* 📊 Personalized recruiter dashboard

### 🌐 Platform Features

* 🔐 Spring Security with BCrypt encryption
* 🎭 Role-based access control (RBAC)
* 📁 Secure multipart file uploads
* 📱 Fully responsive UI (Bootstrap 5)
* 🧠 Dynamic query-based job search
* 🛡️ Input validation

---

## 🛠️ Technology Stack

### Backend

* **Java 17**
* **Spring Boot 3.5.7**
* **Spring Security 6**
* **Spring Data JPA (Hibernate)**
* **Spring Validation**

### Frontend

* **Thymeleaf 3**
* **Bootstrap 5.3.8**
* **jQuery 3.7.1**
* **Font Awesome**
* **Summernote (Rich Text Editor)**

### Database

* **MySQL 8**
* **JPA/Hibernate**
* **Connection Pooling**

### Build & Tooling

* **Maven**
* **Spring Boot DevTools**
* **WebJars**

---

## 🏗️ Architecture

### Architectural Patterns

* **MVC (Model–View–Controller)**
* **Service Layer Pattern**
* **Repository Pattern**
* **Dependency Injection (IoC)**

### Request Lifecycle

```
HTTP Request
   ↓
Spring Security Filter Chain
   ↓
Controller Layer
   ↓
Service Layer (Transactions + Business Logic)
   ↓
Repository Layer (JPA)
   ↓
MySQL Database
   ↓
Thymeleaf View Rendering
```

---

## 🔐 Security Design

* BCrypt password hashing (no plain-text storage)
* Custom `UserDetailsService`
* Role-based authorization (Recruiter / Job Seeker)
* Secure session handling
* Public vs protected route segregation
* Thymeleaf auto-escaping (XSS prevention)

---

## 🗄️ Database Highlights

* **One-to-One mapping** using `@MapsId`
* **Composite unique constraints** (prevents duplicate job applications)
* **Lazy loading** for performance
* **Normalized schema** for scalability

Key entities:

* `Users`
* `UsersType`
* `JobSeekerProfile`
* `RecruiterProfile`
* `JobPostActivity`
* `JobSeekerApply`
* `JobSeekerSave`

---

## 🚀 Installation & Setup

### Prerequisites

* Java 17+
* Maven 3.6+
* MySQL 8+
* IntelliJ / Eclipse / VS Code

### Clone Repository

```bash
git clone https://github.com/yourusername/Bridgeify.git
cd Bridgeify
```

### Configure Database

```sql
CREATE DATABASE jobportal;
```

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/jobportal
spring.datasource.username=YOUR_USERNAME
spring.datasource.password=YOUR_PASSWORD
```

### Build & Run

```bash
./mvnw clean install
./mvnw spring-boot:run
```

📍 App runs at: `http://localhost:8080`

---

## 📡 API Endpoints (Highlights)

### Authentication

| Method | Endpoint        | Access        |
| ------ | --------------- | ------------- |
| GET    | `/login`        | Public        |
| POST   | `/register/new` | Public        |
| GET    | `/logout`       | Authenticated |

### Job Search & Dashboard

| Method | Endpoint            | Access        |
| ------ | ------------------- | ------------- |
| GET    | `/dashboard`        | Authenticated |
| GET    | `/global-search/**` | Public        |

### Recruiter

| Method | Endpoint               |
| ------ | ---------------------- |
| POST   | `/dashboard/addNew`    |
| POST   | `/dashboard/edit/{id}` |

### Job Seeker

| Method | Endpoint                  |
| ------ | ------------------------- |
| POST   | `/job-details/apply/{id}` |
| POST   | `/job-details/save/{id}`  |
| GET    | `/saved-jobs/`            |

---

## 📁 Project Structure

```
com.jobPortal.Bridgeify
 ├── config        # Security & MVC configuration
 ├── controller    # Web controllers
 ├── entity        # JPA entities
 ├── repository    # Data access layer
 ├── services      # Business logic
 ├── util          # File handling & security helpers
 └── resources
     ├── templates # Thymeleaf views
     └── static    # CSS, JS, assets
```

---

## 💡 Technical Highlights

* 🔍 Dynamic query-based job search
* 📁 Secure file upload & download utilities
* 🔐 Custom Spring Security integration
* 🧠 Service-level transaction management
* 🗃️ Optimized database access with projections
* 🎨 Role-aware UI rendering with Thymeleaf

---

## 🔮 Future Enhancements

* REST APIs for mobile clients
* Resume parsing & skill extraction
* ML-based job recommendations
* Recruiter analytics dashboard
* Email notifications
* OAuth2 (Google / LinkedIn)
* Real-time chat system

---

## 🤝 Contributing

Contributions are welcome!
Open an issue or submit a pull request 🚀

---

<div align="center">

**Built with ❤️ using Java & Spring Boot**

</div>
