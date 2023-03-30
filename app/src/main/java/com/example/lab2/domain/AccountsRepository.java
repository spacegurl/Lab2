package com.example.lab2.domain;

import com.example.lab2.domain.entity.LoginAdmin;
import com.example.lab2.domain.entity.LoginUser;
import com.example.lab2.domain.entity.RegistrationUser;

public interface AccountsRepository {

    boolean userLogin(LoginUser loginUser);
    boolean registrationUser(RegistrationUser registrationUser);
    boolean loginAdmin(LoginAdmin loginAdmin);

}
