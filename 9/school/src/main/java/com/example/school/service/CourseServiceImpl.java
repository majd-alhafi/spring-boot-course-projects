package com.example.school.service;

import com.example.school.enitity.Course;
import com.example.school.repository.CourseRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    private final CourseRepository repository;

    public CourseServiceImpl(CourseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    @Override
    public Course getCourseById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Course createCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public Course updateCourse(Course course) {
        return repository.save(course);
    }

    @Override
    public void deleteCourse(int id) {
        Course existingCourse = getCourseById(id);
        repository.delete(existingCourse);
    }

    @Override
    public Course getCourseByCode(String code) {
        return repository.getByCode(code);
    }

    @Override
    public List<Course> getAllCoursesByDepartment(String department) {
        return repository.getAllByDepartment(department);
    }
}
