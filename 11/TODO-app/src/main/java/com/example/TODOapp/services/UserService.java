package com.example.TODOapp.services;

import com.example.TODOapp.entities.TODO;
import com.example.TODOapp.entities.User;

public interface UserService {
    User createUser(User user);

    User addTODOItem(int userId, TODO todo);
}
