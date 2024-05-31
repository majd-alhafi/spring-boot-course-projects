package com.example.TODOapp.entities;

import jakarta.persistence.*;

import java.util.Date;

@Entity(name = "todo_lists")
public class TODO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @Column(name = "name")
    private String name;
    @Column(name = "date")
    private Date date;
    @Column(name = "due_date")
    private Date dueDate;
    @Column(name = "priority")
    private String priority;
    @Column(name = "state")
    private String state;
    @Column(name = "description")
    private String description;
    @ManyToOne()
    @JoinColumn(name = "user_id")
    private User user;

    public TODO() {
    }

    public TODO(String name, Date date, Date dueDate, String priority, String state, String description) {
        this.name = name;
        this.date = date;
        this.dueDate = dueDate;
        this.priority = priority;
        this.state = state;
        this.description = description;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
