package com.example.lab2.data;

import com.example.lab2.data.data_source.AccountsRemoteDataSource;
import com.example.lab2.domain.AccountsRepository;
import com.example.lab2.domain.entity.LoginAdmin;
import com.example.lab2.domain.entity.LoginUser;
import com.example.lab2.domain.entity.RegistrationUser;

public class AccountsRepositoryImplement implements AccountsRepository {

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
