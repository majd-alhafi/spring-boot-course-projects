package com.example.school.controller;

import com.example.school.enitity.Course;
import com.example.school.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<Course> getAllCourses(){
        return service.getAllCourses();
    }
    @GetMapping("/department/{department}")
    public List<Course> getAllCourses(@PathVariable(name = "department") String department){
        return service.getAllCoursesByDepartment(department);
    }
    @GetMapping("/id/{id}")
    public Course getCourseById(@PathVariable(name = "id") int id){
        return service.getCourseById(id);
    }
    @GetMapping("/code/{code}")
    public Course getCourseByCode(@PathVariable(name = "code") String code){
        return service.getCourseByCode(code);
    }
    @PostMapping("/")
    public Course createCourse(@RequestBody Course course){
        return service.createCourse(course);
    }
    @PutMapping("/")
    public Course updateCourse(@RequestBody Course course) {
        return service.updateCourse(course);
    }
    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable(name = "id") int id){
        service.deleteCourse(id);
    }
}
