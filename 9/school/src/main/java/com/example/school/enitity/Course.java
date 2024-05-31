package com.example.school.enitity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @Column(name = "course_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "course_name")
    private String name;
    @Column(name = "course_code")
    private String code;
    @Column(name = "department")
    private String department;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private List<Review> reviews;
    public Course() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
    public Review addReview(Review review){
        if(reviews == null)
            reviews = new ArrayList<>();
        reviews.add(review);
        return review;
    }
}
