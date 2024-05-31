package com.example.thymeleaf.Crud.service;

import com.example.thymeleaf.Crud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getEmployees();

    void save(Employee e);

    Optional<Employee> findById(int id);

    void deleteById(int id);
}
