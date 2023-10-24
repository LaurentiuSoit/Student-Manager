package com.student.student.services;

import com.student.student.exceptions.StudentNotFoundException;
import com.student.student.models.Student;
import com.student.student.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.rmi.StubNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public void addStudent(Student student) {
        studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public void updateStudent(Student updatedStudent) {
        studentRepository.save(updatedStudent);
    }

    public void deleteStudent(String id) {
        studentRepository.deleteById(id);
    }

    public void studentExists(String id) {
        if(!studentRepository.existsById(id))
            throw new StudentNotFoundException("Student with id: " + id + " was not found.");
    }
}
