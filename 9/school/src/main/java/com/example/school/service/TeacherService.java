package com.example.school.service;

import com.example.school.enitity.Course;
import com.example.school.enitity.Student;
import com.example.school.enitity.Teacher;
import com.example.school.request.TeacherRequest;

import java.util.List;

public interface TeacherService {
    List<Teacher> getAllTeachers();

    Teacher getTeacherById(int id);

    Teacher createTeacher(Teacher teacher);

    Teacher updateTeacher(Teacher teacher);

    void deleteTeacher(int id);

    Teacher addCoursesToExisingTeacher(int teacherId, List<Integer> courseIds);

    List<Course> getCourses(int id);
}
