package com.example.school.request;

import com.example.school.enitity.Review;

public class ReviewRequest {
    private int courseId;
    private Review review;

    public ReviewRequest() {
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public Review getReview() {
        return review;
    }

    public void setReview(Review review) {
        this.review = review;
    }
}
