package com.example.school.enitity;

import jakarta.persistence.*;

@Entity
@Table(name = "reviews")
public class Review {
    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "review_text")
    private String text;
    @Column(name = "rating")
    private float rating;

    public Review() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}
