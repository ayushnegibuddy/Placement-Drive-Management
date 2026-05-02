Project Title: Placement-Drive-Management
Project Theme:

Placement Drive Registration and Interview Management System

Members:
Ayush Negi – 590015410
Ayush Kumar – 590014539
Mayank Tanishk – 590015863
Mayank Parmar – 590017039
Sakshi Singh – 590012402
Samiksha Rajan – 590016234
Satyam Pandey – 590016569
Problem Statement:

Managing placement drives manually creates issues such as duplicate registrations, poor student record management, interview scheduling conflicts, and difficulty tracking shortlisted candidates.

The goal of this project is to build a Java Desktop Application that centralizes placement records into one structured system and simplifies the recruitment workflow from student registration to final interview allocation.

Programming Language:

Java — the complete project is developed using Java.

GUI / Frontend:

Java Swing — used to create windows and screens such as login page, student registration, company details, interview schedule, and reports.

Database Connectivity:

JDBC (Java Database Connectivity) — used to connect Java application with database and execute SQL queries.

Database:

MySQL — stores student details, company records, placement drives, interview schedules, and selected candidates.

Main Features:
Student Registration System
Company Drive Management
Interview Slot Allocation
Eligibility Checking based on criteria
Shortlisted Candidate Records
Placement Status Tracking
Admin Dashboard
Search and Report Generation
How to Run the Project:
Step 1:

Run schema.sql in MySQL Workbench to create the database placement_db and required tables.

Step 2:

Open DBConnection.java and update:

DB_USER = "your_username";
DB_PASS = "your_password";
Step 3:

Add mysql-connector-j.jar file into project build path in IntelliJ / Eclipse.

Step 4:

Right-click Main.java and select Run.

Step 5:

Login Credentials:

Admin Login
Username: admin
Password: admin123
Coordinator Login
Username: coordinator
Password: coord123
Step 6:

Test Workflow:

Admin adds company → Students register → Eligibility check → Interview slots assigned → Final selected list generated.
