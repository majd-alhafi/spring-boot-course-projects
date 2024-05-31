package com.example.security.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WelcomeController {
    @GetMapping("/")
    public String welcome(){
        return "welcome";
    }
    @GetMapping("/admin")
    public String admin(){
        return "admin";
    }
    @GetMapping("/user")
    public String user(){
        return "user";
    }
}
