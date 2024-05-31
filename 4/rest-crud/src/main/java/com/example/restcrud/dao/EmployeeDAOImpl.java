package com.example.restcrud.dao;

import com.example.restcrud.entity.Employee;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO{
    private final EntityManager entityManager;
    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    @Override
    public Employee findEmployee(int id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAllEmployees() {
        return entityManager.createQuery("FROM Employee",Employee.class).getResultList();
    }

    @Override
    public void saveEmployee(Employee emp) {
        entityManager.persist(emp);
    }

    @Override
    public void deleteEmployee(int id) {
        entityManager.remove(findEmployee(id));
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return entityManager.merge(employee);
    }
}
