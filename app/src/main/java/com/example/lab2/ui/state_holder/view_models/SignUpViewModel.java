package com.example.lab2.ui.state_holder.view_models;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.ViewModel;

import com.example.lab2.data.models.RegistrationUser;
import com.example.lab2.data.repositories.AccountsRepository;

public class SignUpViewModel extends AndroidViewModel {
    private final AccountsRepository repository = new AccountsRepository(getApplication());

    public SignUpViewModel(@NonNull Application application) {
        super(application);
    }

    public boolean SignUpLogin(String name, String phone, String password) {
        RegistrationUser registrationUser = new RegistrationUser(name, phone, password);
        return repository.registrationUser(registrationUser);
    }
}
