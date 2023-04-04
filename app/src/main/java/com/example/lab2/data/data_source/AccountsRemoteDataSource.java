package com.example.lab2.data.data_source;

import com.example.lab2.data.models.LoginAdmin;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

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
