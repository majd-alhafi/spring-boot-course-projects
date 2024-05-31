package com.example.school.repository;

import com.example.school.enitity.Course;
import com.example.school.enitity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student,Integer> {
}
