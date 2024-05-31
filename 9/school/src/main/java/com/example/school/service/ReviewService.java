package com.example.school.service;

import com.example.school.enitity.Review;
import com.example.school.enitity.Student;
import com.example.school.request.ReviewRequest;

import java.util.List;

public interface ReviewService {

    Review createReview(ReviewRequest review);

    Review updateReview(ReviewRequest review);

    void deleteReview(int id);

    Review getReviewById(int id);
}
