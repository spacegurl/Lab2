package com.example.lab2.data.repositories;

import android.content.Context;

import com.example.lab2.data.data_source.AccountsRemoteDataSource;
import com.example.lab2.data.models.LoginAdmin;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;
import com.example.lab2.data.protocols.AccountsProtocol;

public class AccountsRepository implements AccountsProtocol {

    private final Context context;

    private final AccountsRemoteDataSource dataSource;

    public AccountsRepository(Context context) {
        this.context = context;
        dataSource = new AccountsRemoteDataSource(context);
    }

    @Override
    public boolean userLogin(LoginUser loginUser) {
        return dataSource.checkLoginValid(loginUser);
    }

    @Override
    public boolean registrationUser(RegistrationUser registrationUser) {
        return dataSource.checkRegistrationValid(registrationUser);
    }

    @Override
    public boolean loginAdmin(LoginAdmin loginAdmin, boolean allowed) {
        return dataSource.checkAdminValid(loginAdmin, allowed);
    }
}
