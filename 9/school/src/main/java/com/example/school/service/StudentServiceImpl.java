package com.example.school.service;

import com.example.school.enitity.Course;
import com.example.school.enitity.Student;
import com.example.school.repository.CourseRepository;
import com.example.school.repository.StudentRepository;
import com.example.school.request.StudentRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
    final StudentRepository repository;
    final CourseRepository courseRepository;

    public StudentServiceImpl(StudentRepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student getStudentById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Student createStudent(StudentRequest studentRequest) {
        Student student = studentRequest.getStudent();
        List<Integer> courseIds = studentRequest.getCourseIds();
        List<Course> courses = new ArrayList<>();
        courseIds.forEach(courseId -> {
            Course course = courseRepository.findById(courseId).get();
            courses.add(course);
        });
        student.setCourses(courses);
        return repository.save(student);
    }

    @Override
    public Student updateStudent(Student student) {
        return repository.save(student);
    }

    @Override
    public void deleteStudent(int id) {
        repository.delete(getStudentById(id));
    }

    @Override
    public Student addCoursesToExisitingStudent(int studentId, List<Integer> courseIds) {
        Student student = getStudentById(studentId);
        List<Course> courses = new ArrayList<>();
        courseIds.forEach(courseId -> {
            Course course = courseRepository.findById(courseId).get();
            courses.add(course);
        });
        student.addCourses(courses);
        return repository.save(student);
    }
}
