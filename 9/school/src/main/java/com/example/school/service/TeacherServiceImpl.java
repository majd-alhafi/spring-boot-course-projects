package com.example.school.service;

import com.example.school.enitity.Course;
import com.example.school.enitity.Student;
import com.example.school.enitity.Teacher;
import com.example.school.repository.CourseRepository;
import com.example.school.repository.TeacherRepository;
import com.example.school.request.TeacherRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TeacherServiceImpl implements TeacherService{
    private final TeacherRepository repository;
    private final CourseRepository courseRepository;

    public TeacherServiceImpl(TeacherRepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return repository.findAll();
    }

    @Override
    public Teacher getTeacherById(int id) {
        return repository.findById(id).get();
    }

    @Override
    public Teacher createTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return repository.save(teacher);
    }

    @Override
    public void deleteTeacher(int id) {
        repository.delete(getTeacherById(id));
    }

    @Override
    public Teacher addCoursesToExisingTeacher(int teacherId, List<Integer>courseIds) {
        Teacher teacher = getTeacherById(teacherId);
        List<Course> courses = new ArrayList<>();
        courseIds.forEach(courseId -> {
            Course course = courseRepository.findById(courseId).get();
            courses.add(course);
        });
        teacher.addCourses(courses);
        return repository.save(teacher);
    }

    @Override
    public List<Course> getCourses(int id) {
        Teacher teacher = getTeacherById(id);
        return teacher.getCourses();
    }
}
