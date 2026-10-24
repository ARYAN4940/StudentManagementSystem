package com.example.Student.controller;

import com.example.Student.entity.Student;
import com.example.Student.repository.StudentRepository;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")

public class StudentController{

    private final StudentRepository studentRepository;

    public StudentController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @PostMapping

    public ResponseEntity<Student>addStudent(@RequestBody Student student) {
        Student savedStudent = studentRepository.save(student);

        return ResponseEntity.status(HttpStatus.CREATED).body(savedStudent);
    }

    @GetMapping

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @GetMapping("/{id}")

    public ResponseEntity<Student>getStudentById(@PathVariable Long id) {
        return studentRepository.findById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<Void>deleteStudent(@PathVariable Long id) {
        if(! studentRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        studentRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}