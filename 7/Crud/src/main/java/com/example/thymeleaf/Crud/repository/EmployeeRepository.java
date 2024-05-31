package com.example.thymeleaf.Crud.repository;

import com.example.thymeleaf.Crud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    List<Employee> findAllByOrderByLastNameAsc();
}
