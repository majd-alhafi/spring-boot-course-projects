package com.example.school.controller;

import com.example.school.enitity.Review;
import com.example.school.enitity.Teacher;
import com.example.school.request.ReviewRequest;
import com.example.school.service.ReviewService;
import com.example.school.service.TeacherService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService service;

    public ReviewController(ReviewService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public Review getReviewById(@PathVariable(name = "id") int id){
        return service.getReviewById(id);
    }
    @PostMapping("/")
    public Review createReview(@RequestBody ReviewRequest review){
        return service.createReview(review);
    }
    @PutMapping("/")
    public Review updateReview(@RequestBody ReviewRequest review) {
        return service.updateReview(review);
    }
    @DeleteMapping("/{id}")
    public void deleteReview(@PathVariable(name = "id") int id){
        service.deleteReview(id);
    }
}
