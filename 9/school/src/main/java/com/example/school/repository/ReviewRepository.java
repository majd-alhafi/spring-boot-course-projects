package com.example.school.repository;

import com.example.school.enitity.Review;
import com.example.school.enitity.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review,Integer> {
}
