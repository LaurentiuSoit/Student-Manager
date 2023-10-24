A backend service written in Java, using the Spring Boot framework, that manages a MySQL database of Students.
It features all CRUD operations and is hosted on AWS, alongside its database.

Address : 16.171.32.104:8080

Operations : 
- 16.171.32.104:8080/getAllStudents
  A GET Request that returns all students and their relevant information from the database
- 16.171.32.104:8080/addStudent
  A POST Request that accepts a JSON Object from the Request Body, parses it and adds it to the database as a new student
- 16.171.32.104:8080/updateStudent
  A PUT Request that accepts a JSON Object from the Request Body, parses it and updates an already existing student
- 16.171.32.104:8080/deleteStudent/{id}
  A DELETE Request that removes the student whose id matches the one specified from the database
