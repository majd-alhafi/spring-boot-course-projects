package com.example.restcrud.repository;

import com.example.restcrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(path = "members") // the end point name will be "/members"
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    
}
