package com.example.Student.repository;

import com.example.Student.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository
    extends JpaRepository<Student, Long> {

    }