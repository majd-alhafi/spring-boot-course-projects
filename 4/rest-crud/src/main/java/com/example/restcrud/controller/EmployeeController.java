package com.example.restcrud.controller;

import com.example.restcrud.entity.Employee;
import com.example.restcrud.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    private final EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> getAllEmployee(){
        return employeeService.findAllEmployees();
    }

    @GetMapping("/employees/{employeeId}")
    public Optional<Employee> findEmployee(@PathVariable(name = "employeeId") int id){
        return employeeService.findEmployee(id);
    }

    @PostMapping("/employees")
    public void createEmployee(@RequestBody Employee employee){
        employeeService.saveEmployee(employee);
    }

    @PutMapping("/employees")
    public Employee updateEmployee(@RequestBody Employee employee){
       return employeeService.updateEmployee(employee);
    }

    @DeleteMapping("/employees/{employeeId}")
    public void deleteEmployee(@PathVariable(name="employeeId") int id){
        employeeService.deleteEmployee(id);
    }
}
