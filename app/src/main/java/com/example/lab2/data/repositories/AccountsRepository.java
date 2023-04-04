package com.example.lab2.data.repositories;

import com.example.lab2.data.data_source.AccountsRemoteDataSource;
import com.example.lab2.data.models.LoginAdmin;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;
import com.example.lab2.data.protocols.AccountsProtocol;

public class AccountsRepository implements AccountsProtocol {

    private final AccountsRemoteDataSource dataSource = new AccountsRemoteDataSource();
    @Override
    public boolean userLogin(LoginUser loginUser) {
        return dataSource.checkLoginValid(loginUser);
    }

    @Override
    public boolean registrationUser(RegistrationUser registrationUser) {
        return dataSource.checkRegistrationValid(registrationUser);
    }

    @Override
    public boolean loginAdmin(LoginAdmin loginAdmin) {
        return dataSource.checkAdminValid(loginAdmin);
    }
}
