package com.example.lab2.data.data_source;

import com.example.lab2.domain.entity.LoginAdmin;
import com.example.lab2.domain.entity.LoginUser;
import com.example.lab2.domain.entity.RegistrationUser;

public class AccountsRemoteDataSource {

    public boolean checkLoginValid(LoginUser loginUser){
        return !loginUser.getPhone().equals("") && !loginUser.getPassword().equals("");
    }

    public boolean checkRegistrationValid(RegistrationUser registrationUser){
        return !registrationUser.getName().equals("") &&
                !registrationUser.getPassword().equals("") &&
                !registrationUser.getPhone().equals("");
    }

    public boolean checkAdminValid(LoginAdmin loginAdmin){
        return !loginAdmin.getPhone().equals("") &&
                !loginAdmin.getPassword().equals("");
    }
}
