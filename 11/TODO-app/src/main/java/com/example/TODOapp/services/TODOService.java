package com.example.TODOapp.services;

import com.example.TODOapp.entities.TODO;

import java.util.List;

public interface TODOService {
    List<TODO> getTODOList(int userId);

    TODO getTODOItem(int itemId);

    List<TODO> getTODOItemsByState(int userId,String state);
}
