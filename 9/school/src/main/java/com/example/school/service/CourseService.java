package com.example.school.service;

import com.example.school.enitity.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourses();

    Course getCourseById(int id);

    Course createCourse(Course course);

    Course updateCourse(Course course);

    void deleteCourse(int id);

    Course getCourseByCode(String code);

    List<Course> getAllCoursesByDepartment(String department);
}
