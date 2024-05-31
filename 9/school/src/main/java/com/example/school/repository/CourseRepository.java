package com.example.school.repository;

import com.example.school.enitity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course,Integer> {
    Course getByCode(String code);
    List<Course> getAllByDepartment(String department);
}
