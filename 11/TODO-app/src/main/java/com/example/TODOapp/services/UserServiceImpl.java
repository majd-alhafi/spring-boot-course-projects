package com.example.TODOapp.services;

import com.example.TODOapp.entities.TODO;
import com.example.TODOapp.entities.User;
import com.example.TODOapp.repositories.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
        this.repository = repository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return repository.save(user);
    }

    @Override
    public User addTODOItem(int userId, TODO todo) {
        System.out.println("**addTODOItem**");
        User user = null;
        try {
            user = repository.findById(userId).get();
        }
        catch (Exception e){
            System.out.println("There is exception " + e.getMessage());
        }
        user.addToTODOList(todo);
        return repository.save(user);
    }
}
