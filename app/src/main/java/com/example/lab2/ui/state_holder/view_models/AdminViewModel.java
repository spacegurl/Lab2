package com.example.lab2.ui.state_holder.view_models;

import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginAdmin;
import com.example.lab2.data.repositories.AccountsRepository;

public class AdminViewModel extends ViewModel {
    private final AccountsRepository repository = new AccountsRepository();

    public boolean AdminLogin(String phone, String password){
        LoginAdmin loginAdmin = new LoginAdmin(phone, password);
        return repository.loginAdmin(loginAdmin);
    }
}
