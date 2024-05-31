package com.example.school.controller;

import com.example.school.enitity.Course;
import com.example.school.enitity.Student;
import com.example.school.enitity.Teacher;
import com.example.school.request.TeacherRequest;
import com.example.school.service.StudentService;
import com.example.school.service.TeacherService;
import org.apache.coyote.Request;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teachers")
public class TeacherController {
    private final TeacherService service;

    public TeacherController(TeacherService service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<Teacher> getAllTeachers(){
        return service.getAllTeachers();
    }

    @GetMapping("/{id}")
    public Teacher getTeacherById(@PathVariable(name = "id") int id){
        return service.getTeacherById(id);
    }
    @GetMapping("/{id}/courses")
    public List<Course> getCourses(@PathVariable(name = "id") int id){
        return service.getCourses(id);
    }
    @PostMapping("/")
    public Teacher createTeacher(@RequestBody Teacher teacher){
        return service.createTeacher(teacher);
    }
    @PostMapping("/{teacherId}/add-courses")
    public Teacher addCoursesToExisingTeacher(@PathVariable int teacherId, @RequestBody TeacherRequest teacherRequest){
        return service.addCoursesToExisingTeacher(teacherId,teacherRequest.getCourseIds());
    }
    @PutMapping("/")
    public Teacher updateTeacher(@RequestBody Teacher teacher) {
        return service.updateTeacher(teacher);
    }
    @DeleteMapping("/{id}")
    public void deleteTeacher(@PathVariable(name = "id") int id){
        service.deleteTeacher(id);
    }
}
