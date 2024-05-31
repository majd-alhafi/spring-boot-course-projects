package com.example.thymeleaf.Crud.service;

import com.example.thymeleaf.Crud.entity.Employee;
import com.example.thymeleaf.Crud.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.findAllByOrderByLastNameAsc();
    }

    @Override
    public void save(Employee e) {
        employeeRepository.save(e);
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
