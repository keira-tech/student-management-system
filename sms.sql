create database SMS;
use SMS;

CREATE TABLE users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role ENUM('admin','student') DEFAULT 'student'
);


CREATE TABLE students (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    email VARCHAR(100) UNIQUE,
    phone VARCHAR(20),
    course VARCHAR(100)
);
ALTER TABLE students
DROP COLUMN course;
select * from users;
select * from students;
alter table students add age int after name;

ALTER TABLE students
ADD COLUMN user_id INT;

UPDATE students s
JOIN users u ON s.name = u.username
SET s.user_id = u.id;

ALTER TABLE students
ADD CONSTRAINT fk_user
FOREIGN KEY (user_id) REFERENCES users(id);


CREATE TABLE courses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    course_name VARCHAR(100)
);
select * from courses;
alter table courses add lecture varchar(25) after course_name;
ALTER TABLE courses
CHANGE lecture lecturer varchar(25);

CREATE TABLE grades (
    id INT AUTO_INCREMENT PRIMARY KEY,
    student_id INT,
    course_id INT,
    grade VARCHAR(5),
    FOREIGN KEY (student_id) REFERENCES students(id),
    FOREIGN KEY (course_id) REFERENCES courses(id)
);
CREATE TABLE student_courses (
    student_id INT NOT NULL,
    course_id INT NOT NULL,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES students(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES courses(id) ON DELETE CASCADE
);
