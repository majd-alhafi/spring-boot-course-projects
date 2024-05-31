package com.example.school.service;

import com.example.school.enitity.Student;
import com.example.school.request.StudentRequest;

import java.util.List;

public interface StudentService {
    List<Student> getAllStudents();

    Student getStudentById(int id);

    Student createStudent(StudentRequest studentRequest);

    Student updateStudent(Student student);

    void deleteStudent(int id);

    Student addCoursesToExisitingStudent(int studentId, List<Integer> courseIds);
}
