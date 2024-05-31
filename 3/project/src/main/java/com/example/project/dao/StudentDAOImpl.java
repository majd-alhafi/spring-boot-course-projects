package com.example.project.dao;

import com.example.project.entities.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class StudentDAOImpl implements StudentDAO{
    private final EntityManager entityManager;
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        /*
        *
        * the entityManager will be auto created by spring framework.
        * */
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void save(Student student) {
        entityManager.persist(student);
    }

    @Override
    public Student findById(int id) {
        return entityManager.find(Student.class,id);
    }

    @Override
    public List<Student> findAll() {
        String query = "FROM Student";
        //the query should match JPQL where we use the entity name and entity filed.
        //'Student' is the class name.
        return entityManager.createQuery(query,Student.class).getResultList();
    }

    @Override
    public List<Student> findByLastName(String lastName) {
        String query = "FROM Student WHERE lastName=:theData";
        TypedQuery<Student> typedQuery = entityManager.createQuery(query,Student.class);
        typedQuery.setParameter("theData",lastName);
        return typedQuery.getResultList();
    }

    @Override
    @Transactional
    public Student updateStudent(Student student) {
        return entityManager.merge(student);
    }

    @Override
    @Transactional
    public void deleteStudent(int id) {
        entityManager.remove(findById(id));
    }
}
