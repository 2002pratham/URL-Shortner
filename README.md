URL Shortener Application
A simple URL shortener service built with Spring Boot, MongoDB, and RESTful APIs. This project allows users to shorten long URLs and redirect them to their original destinations. It supports expiration of shortened URLs and proper error handling.

Features
Shorten URL: Shorten long URLs to a unique identifier.
Redirect: Redirect users to the original URL using the shortened identifier.
Expiration: URLs expire automatically after a specified time (using MongoDB TTL).
Error Handling: Custom error messages for not found URLs.
Technologies Used
Spring Boot: The backend framework to build the REST API.
MongoDB: The NoSQL database to store URLs and their metadata.
Spring Data MongoDB: To interact with MongoDB through repositories.
Java 17+: Programming language used to implement the application.
Lombok: To reduce boilerplate code for getters, setters, constructors, etc.
RandomStringUtils: For generating random shortened URL IDs.
