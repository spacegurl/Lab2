package com.example.lab2.ui.state_holder.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginAdmin;
import com.example.lab2.data.repositories.AccountsRepository;

public class AdminViewModel extends AndroidViewModel {
    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public AdminViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean AdminLogin(String phone, String password, boolean allowed){
        LoginAdmin loginAdmin = new LoginAdmin(phone, password);
        return repository.loginAdmin(loginAdmin, allowed);
    }
}
