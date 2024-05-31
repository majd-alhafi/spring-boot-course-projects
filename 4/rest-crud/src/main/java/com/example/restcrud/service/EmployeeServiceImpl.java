package com.example.restcrud.service;

import com.example.restcrud.entity.Employee;
import com.example.restcrud.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    /*private final EmployeeDAO employeeDAO;
    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }
     */
    private final EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }
    /*
    @Override
    public List<Employee> findAllEmployees() {
        return employeeDAO.findAllEmployees();
    }

    @Override
    public Employee findEmployee(int id) {
        return employeeDAO.findEmployee(id);
    }

    @Override
    @Transactional
    public void saveEmployee(Employee emp) {
        employeeDAO.saveEmployee(emp);
    }

    @Override
    @Transactional
    public void deleteEmployee(int id) {
        employeeDAO.deleteEmployee(id);
    }

    @Override
    @Transactional
    public Employee updateEmployee(Employee employee) {
        return employeeDAO.updateEmployee(employee);
    }
     */

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployee(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void saveEmployee(Employee emp) {
        employeeRepository.save(emp);
    }

    @Override
    public void deleteEmployee(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
