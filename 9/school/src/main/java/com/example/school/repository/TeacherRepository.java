package com.example.school.repository;

import com.example.school.enitity.Student;
import com.example.school.enitity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
