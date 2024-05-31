package com.example.school.request;

import com.example.school.enitity.Teacher;

import java.util.List;

public class TeacherRequest {
    private List<Integer> courseIds;
    private Teacher teacher;

    public TeacherRequest() {
    }

    public List<Integer> getCourseIds() {
        return courseIds;
    }

    public void setCourseIds(List<Integer> courseIds) {
        this.courseIds = courseIds;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
