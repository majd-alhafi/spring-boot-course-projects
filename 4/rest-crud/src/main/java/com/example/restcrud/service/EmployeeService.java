package com.example.restcrud.service;

import com.example.restcrud.entity.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    Optional<Employee> findEmployee(int id);
    void saveEmployee(Employee emp);

    void deleteEmployee(int id);

    Employee updateEmployee(Employee employee);
}
