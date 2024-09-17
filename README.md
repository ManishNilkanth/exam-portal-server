Overview
The Exam Portal Backend is a Spring Boot application for managing quizzes in an exam portal. It features JWT-based security and uses MySQL for data storage. Admins can create, publish, and manage quizzes, while normal users can access and attempt them.

Features
Admin:
Create and publish quizzes.
Manage questions and view submissions.

Normal Users:
View and attempt quizzes
Access results

Technologies
Spring Boot: Framework for building the backend
JWT: For secure API access
MySQL: Database for storing data
swagger: swagger for documentation 

Authentication
Include JWT in the Authorization header: Authorization: Bearer <your_jwt_token>
