package com.example.TODOapp.controllers;

import com.example.TODOapp.entities.TODO;
import com.example.TODOapp.entities.User;
import com.example.TODOapp.services.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping("/register")
    public User createUser(@RequestBody User user){
        return service.createUser(user);
    }
    @PostMapping("/{userId}/add-todo-item")
    public User addTODOItem(@PathVariable int userId, @RequestBody TODO todo){
        return service.addTODOItem(userId,todo);
    }
}
