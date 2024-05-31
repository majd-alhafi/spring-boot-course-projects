package com.example.project.dao;

import com.example.project.entities.Student;

import java.util.List;

public interface StudentDAO {
    void save(Student student);
    Student findById(int id);
    List<Student> findAll();
    List<Student> findByLastName(String lastName);

    Student updateStudent(Student student);
    void deleteStudent(int id);
}
