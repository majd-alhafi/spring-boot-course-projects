package com.example.aop.service;

import com.example.aop.dao.AccountDAO;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements AccountService{
    private final AccountDAO dao;

    public AccountServiceImpl(AccountDAO dao) {
        this.dao = dao;
    }

    @Override
    public void addAccount() {
        dao.addAccount();
    }
}
