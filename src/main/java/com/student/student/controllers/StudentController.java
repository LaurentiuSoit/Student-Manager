package com.student.student.controllers;

import com.student.student.models.Student;
import com.student.student.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/getAllStudents")
    public ResponseEntity<List<Student>> getAllStudents(){
        return new ResponseEntity<>(studentService.getAllStudents(), HttpStatus.OK);
    }

    @PostMapping("/addStudent")
    public ResponseEntity<Object> addStudent(@RequestBody Student student){
        studentService.addStudent(student);
        return new ResponseEntity<>("Student with id: " + student.getId() + " was added.", HttpStatus.OK);
    }

    @PutMapping("/updateStudent")
    public ResponseEntity<Object> updateStudent(@RequestBody Student updatedStudent){
        studentService.studentExists(updatedStudent.getId());
        studentService.updateStudent(updatedStudent);
        return new ResponseEntity<>("Student with id: " + updatedStudent.getId() + " was updated.", HttpStatus.OK);
    }

    @DeleteMapping("/deleteStudent/{id}")
    public ResponseEntity<Object> deleteStudent(@PathVariable String id){
        studentService.studentExists(id);
        studentService.deleteStudent(id);
        return new ResponseEntity<>("Student with id: " + " was deleted.", HttpStatus.OK);
    }
}
