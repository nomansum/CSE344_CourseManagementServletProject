## Database: web_app

### Table: users
- Columns:
  - `username`: VARCHAR(32) - Primary key for uniquely identifying users.
  - `email`: VARCHAR(64) - Stores the email address of the user.
  - `password`: VARCHAR(32) - Stores the password of the user.
  - `role`: VARCHAR(8) - Represents the role of the user (e.g., admin, student, teacher).
  - `registration`: INT(64) - Stores registration information of the user.

### Table: courses
- Columns:
  - `courseId`: VARCHAR(32) - Primary key for uniquely identifying courses.
  - `courseName`: VARCHAR(32) - Stores the name of the course.
  - `credit`: FLOAT(32,1) - Represents the credit value of the course.
  - `teacherName`: VARCHAR(32) - Foreign key referencing the `username` column in the `users` table, representing the teacher of the course.

### Table: course_reg
- Columns:
  - `reg_sl`: INT(128) - Primary key with AUTO_INCREMENT, representing the registration serial number.
  - `courseId`: VARCHAR(32) - Foreign key referencing the `courseId` column in the `courses` table.
  - `student_name`: VARCHAR(32) - Foreign key referencing the `username` column in the `users` table, representing the student's name.
  - `student_reg`: INT(64) - Stores the registration information of the student.
