package com.example.restcrud.dao;

import com.example.restcrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    //Employee createEmployee();
    Employee findEmployee(int id);
    List<Employee> findAllEmployees();

    void saveEmployee(Employee emp);

    void deleteEmployee(int id);

    Employee updateEmployee(Employee employee);
}
