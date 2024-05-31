package com.example.school.service;

import com.example.school.enitity.Course;
import com.example.school.enitity.Review;
import com.example.school.enitity.Teacher;
import com.example.school.repository.CourseRepository;
import com.example.school.repository.ReviewRepository;
import com.example.school.request.ReviewRequest;
import org.springframework.stereotype.Service;

@Service
public class ReviewServiceImpl implements ReviewService{
    private final ReviewRepository repository;
    private final CourseRepository courseRepository;
    public ReviewServiceImpl(ReviewRepository repository, CourseRepository courseRepository) {
        this.repository = repository;
        this.courseRepository = courseRepository;
    }
    @Override
    public Review getReviewById(int id) {
        return repository.findById(id).get();
    }
    @Override
    public Review createReview(ReviewRequest review) {
        Course course = courseRepository.findById(review.getCourseId()).get();
        Review reviewObj = review.getReview();
        course.addReview(reviewObj);
        return repository.save(reviewObj); //The association will be automatically persisted due to the cascade settings.
    }

    @Override
    public Review updateReview(ReviewRequest review) {
        return null;
    }

    @Override
    public void deleteReview(int id) {
        repository.delete(getReviewById(id));
    }
}
