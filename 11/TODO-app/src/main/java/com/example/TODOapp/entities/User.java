package com.example.TODOapp.entities;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {
    @Id()
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "username",unique = true)
    private String username;
    @Column(name = "email",unique = true)
    private String email;
    @Column(name = "password")
    private String password;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<TODO> todoList;
    public User() {
    }

    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String userName) {
        this.username = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<TODO> getTodoList() {
        return todoList;
    }

    public void setTodoList(List<TODO> todoList) {
        this.todoList = todoList;
    }
    public void addToTODOList(TODO todo){
        if(this.todoList == null)
            this.todoList = new ArrayList<>();
        this.todoList.add(todo);
    }
}
