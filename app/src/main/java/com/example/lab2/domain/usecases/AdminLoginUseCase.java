package com.example.lab2.domain.usecases;

import com.example.lab2.domain.AccountsRepository;
import com.example.lab2.domain.entity.LoginAdmin;

public class AdminLoginUseCase {
    private final AccountsRepository repository;

    public AdminLoginUseCase(AccountsRepository repository) {
        this.repository = repository;
    }

    public boolean loginAdmin(LoginAdmin loginAdmin){
        return repository.loginAdmin(loginAdmin);
    }
}
