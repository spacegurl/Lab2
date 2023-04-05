package com.example.lab2.ui.state_holder.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class SignInViewModel extends AndroidViewModel {
    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public SignInViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean SignInLogin(String phone, String password) {
        LoginUser loginUser = new LoginUser(phone, password);
        return repository.userLogin(loginUser);
    }
}
