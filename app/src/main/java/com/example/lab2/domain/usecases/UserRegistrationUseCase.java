package com.example.lab2.domain.usecases;

import com.example.lab2.domain.AccountsRepository;
import com.example.lab2.domain.entity.RegistrationUser;

public class UserRegistrationUseCase {
    private final AccountsRepository repository;

    public UserRegistrationUseCase(AccountsRepository repository) {
        this.repository = repository;
    }

    public boolean registrationUser(RegistrationUser registrationUser){
        return repository.registrationUser(registrationUser);
    }
}
