package com.example.restcrud.controller;

import com.example.restcrud.entity.Student;
import com.example.restcrud.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("students")
public class StudentController {
    private List<Student> students = new ArrayList<>();
    @PostConstruct
    void loadData(){
        students.add(new Student("majd","alhafi"));
        students.add(new Student("majed","alrefaie"));
        students.add(new Student("omar","alhalabi"));
        students.add(new Student("aghead","alsamdi"));
    }
    @GetMapping("/all")
    List<Student> getAllStudents(){
        return students; //Here spring will use Jackson to convert the POJO into JSON using getter methods;
    }
    @GetMapping("/{studentId}")
    Student getStudent(@PathVariable(name="studentId") int id){
        if(id >= students.size() || id < 0)
            throw new StudentNotFoundException("student id not found - " + id);
        return students.get(id); //name of the @PathVariable should match the name in the URL;
    }

}
