package com.example.school.request;

import com.example.school.enitity.Student;

import java.util.List;

public class StudentRequest {
    private List<Integer> courseIds;
    private Student student;

    public StudentRequest() {
    }

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
}
