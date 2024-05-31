package com.example.school.controller;

import com.example.school.enitity.Course;
import com.example.school.enitity.Student;
import com.example.school.request.StudentRequest;
import com.example.school.service.CourseService;
import com.example.school.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<Student> getAllStudents(){
        return service.getAllStudents();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable(name = "id") int id){
        return service.getStudentById(id);
    }
    @PostMapping("/")
    public Student createStudent(@RequestBody StudentRequest studentRequest){
        return service.createStudent(studentRequest);
    }
    @PostMapping("/{studentId}/add-courses")
    public Student addCoursesToExisitingStudent(@RequestBody StudentRequest studentRequest, @PathVariable int studentId){
        return service.addCoursesToExisitingStudent(studentId,studentRequest.getCourseIds());
    }
    @PutMapping("/")
    public Student updateStudent(@RequestBody Student student) {
        return service.updateStudent(student);
    }
    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable(name = "id") int id){
        service.deleteStudent(id);
    }
}
