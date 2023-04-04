package com.example.lab2.ui.state_holder.view_models;

import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.RegistrationUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class SignUpViewModel extends ViewModel {
    private final AccountsRepository repository = new AccountsRepository();

    public boolean SignUpLogin(String name, String phone, String password) {
        RegistrationUser registrationUser = new RegistrationUser(name, phone, password);
        return repository.registrationUser(registrationUser);
    }
}
