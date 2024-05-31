package com.example.aop.controller;

import com.example.aop.service.AccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "accounts")
public class AccountController {
    private final AccountService service;

    public AccountController(AccountService service) {
        this.service = service;
    }

    @GetMapping(path = "/add-account")
    public void addAccountController(){
        service.addAccount();
    }
}
