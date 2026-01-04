# MovieCatalog
🎬 Movie Catalog Microservices (Java Brains)

This project is a Spring Boot Microservices architecture implementation inspired by the Java Brains YouTube microservices series.
It demonstrates how multiple independent services communicate using Spring Cloud, Eureka Discovery Server, and an API Gateway.

🧩 Microservices Overview

The system is composed of the following services:

1️⃣ Discovery Server (Eureka)

Service registry using Netflix Eureka

All microservices register themselves here

Enables service discovery and load balancing

Port: 8761

2️⃣ API Gateway

Built using Spring Cloud Gateway

Acts as a single entry point for all client requests

Routes requests to downstream services using service discovery

Port: 9000

3️⃣ Movie Info Service

Provides basic movie information (movie ID, name, description)

Acts as a data provider service

Port: 8072

4️⃣ Rating Data Service

Provides movie ratings for users

Returns rating information based on user ID

Port: 8074

5️⃣ Movie Catalog Service

Aggregates data from:

Movie Info Service

Rating Data Service

Produces a combined movie catalog response for users

Port: 8070

🗂 Project Structure
MovieCatalog/
│── api-gateway/
│── discovery-server/
│── movie-catalog-service/
│── movie-info-service/
│── rating-data-service/
│── .gitignore
│── README.md


Each service is a standalone Spring Boot application.

🔄 Service Communication Flow
Client
  ↓
API Gateway
  ↓
Movie Catalog Service
  ↓        ↓
Movie Info   Rating Data


Services communicate using REST APIs

Service names are resolved dynamically using Eureka

🚀 How to Run the Project
Prerequisites

Java 8+ / Java 11+

Maven

Git

Step 1️⃣ Start Discovery Server
cd discovery-server
mvn spring-boot:run


Access Eureka Dashboard:

http://localhost:8761

Step 2️⃣ Start Other Services (Any Order)
cd movie-info-service
mvn spring-boot:run

cd rating-data-service
mvn spring-boot:run

cd movie-catalog-service
mvn spring-boot:run

cd api-gateway
mvn spring-boot:run

🌐 Sample API Calls
Via API Gateway (Recommended)
http://localhost:9000/movie-catalog-service/catalog/foo

Direct Service Access
http://localhost:8070/catalog/foo

🛠 Technologies Used

Java

Spring Boot

Spring Cloud

Eureka Discovery Server

Spring Cloud Gateway

REST APIs

Maven

Git

📚 Learning Reference

This project is based on the Java Brains Microservices Tutorial Series, created for learning:

Microservice architecture

Service discovery

API Gateway

Inter-service communication
