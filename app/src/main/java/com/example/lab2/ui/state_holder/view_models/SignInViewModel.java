package com.example.lab2.ui.state_holder.view_models;

import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class SignInViewModel extends ViewModel {
    private final AccountsRepository repository = new AccountsRepository();

    public boolean SignInLogin(String phone, String password) {
        LoginUser loginUser = new LoginUser(phone, password);
        return repository.userLogin(loginUser);
    }
}
