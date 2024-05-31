package com.example.TODOapp.repositories;

import com.example.TODOapp.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Integer> {
}
