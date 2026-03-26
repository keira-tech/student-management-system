#  Student Management System

This is a simple **Student Management System** I built using **Java Swing and MySQL**.
The goal of this project was to create an easy-to-use desktop application where an admin can manage students, courses, and grades, while students can log in and view their own information.



# What this system can do

# Admin side

* Add, update, and delete students
* Manage courses
* Assign and update grades
* Search for students, courses, or grades
* Generate reports

# Student side

* Log in with their account
* View their courses
* View their grades
* Access a simple dashboard



# What I used

* Java (Swing and AWT for the interface)
* MySQL (database)
* JDBC (to connect Java and MySQL)
* NetBeans (IDE)



# How the database is organized

The system uses four main tables:

* `users` → stores login details (username, password, role)
* `students` → stores student information
* `courses` → stores available courses
* `grades` → links students to courses with their grades

Each student is linked to a user account, so when a student logs in, they only see their own data.



# How it works (simple flow)

1. A user logs in
2. The system checks their role

   * If admin → opens Admin Dashboard
   * If student → opens Student Dashboard
3. If it's a student, their ID is used to:

   * Load their courses
   * Load their grades


