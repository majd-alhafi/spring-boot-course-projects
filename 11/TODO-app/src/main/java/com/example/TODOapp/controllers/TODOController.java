package com.example.TODOapp.controllers;

import com.example.TODOapp.entities.TODO;
import com.example.TODOapp.services.TODOService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("{userId}/todo-list")
public class TODOController {
    private final TODOService service;

    public TODOController(TODOService service) {
        this.service = service;
    }
    @GetMapping("/")
    public List<TODO> getTODOList(@PathVariable int userId){
        return service.getTODOList(userId);
    }
    @GetMapping("/{itemId}")
    public TODO getTODOItemById(@PathVariable int userId, @PathVariable int itemId){
        return service.getTODOItem(itemId);
    }
    @GetMapping("/filtering")
    public List<TODO> getTODOItemsByState(@PathVariable int userId,@RequestParam String state){
        return service.getTODOItemsByState(userId,state);
    }
}
