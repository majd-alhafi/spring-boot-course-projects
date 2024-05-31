package com.example.TODOapp.repositories;

import com.example.TODOapp.entities.TODO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TODORepository extends JpaRepository<TODO,Integer> {
    List<TODO> findAllByUserId(int userId);
    List<TODO> findAllByUserIdAndState(int userId,String state);
}
