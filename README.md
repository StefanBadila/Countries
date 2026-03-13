# Countries Management System (Spring Boot API)
A robust backend application built with Java and Spring Boot, designed for managing a geographical database of countries. This project demonstrates a clean RESTful architecture, global exception handling, and seamless data persistence using Spring Data JPA.
# How it Works
The application acts as a centralized service for geographical data management.

# Key Features
* Real-time CRUD Operations: Full support for Creating, Reading, Updating, and Deleting country resources.
* Data Persistence: Integrated with Spring Data JPA for reliable storage and retrieval of country information.
* Global Exception Handling: A centralized system that ensures consistent and descriptive error responses (e.g., handling duplicate entries or missing fields).
* Automated Data Seeding: Pre-configured to load initial data from a countries.json file for immediate testing and development.
* Input Validation: Robust server-side validation to ensure every entry has a mandatory capital city and population data.
* Development Ready: Includes pre-recorded HTTP request logs for quick API testing and debugging.

# API Logic
* Validation: When a user attempts to add a country, the service checks for existing entries. If the country name (e.g., "USA") already exists, it triggers a custom conflict exception.
* Error Responses: If mandatory fields are missing, the GlobalExceptionHandler intercepts the request and returns a structured JSON error message with a "400 Bad Request" status.
* Data Flow: The CountryController receives requests, delegates logic to the service layer, and uses the CountryRepository to communicate with the database.

# Tech Stack
* Backend: Java 17+, Spring Boot 3.x.
* Persistence: Spring Data JPA, Hibernate.
* Build Tool: Gradle.
* Database: H2 (In-memory).
* Testing: .http request logs.
