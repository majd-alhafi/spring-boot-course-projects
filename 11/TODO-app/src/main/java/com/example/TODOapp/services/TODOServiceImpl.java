package com.example.TODOapp.services;

import com.example.TODOapp.entities.TODO;
import com.example.TODOapp.repositories.TODORepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TODOServiceImpl implements TODOService{
    private final TODORepository repository;

    public TODOServiceImpl(TODORepository repository) {
        this.repository = repository;
    }

    @Override
    public List<TODO> getTODOList(int userId) {
        return repository.findAllByUserId(userId);
    }

    @Override
    public TODO getTODOItem(int itemId) {
        return repository.findById(itemId).get();
    }

    @Override
    public List<TODO> getTODOItemsByState(int userId, String state) {
        return repository.findAllByUserIdAndState(userId, state);
    }
}
