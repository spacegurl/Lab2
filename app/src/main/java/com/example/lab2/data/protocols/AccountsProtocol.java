package com.example.lab2.data.protocols;

import com.example.lab2.data.models.LoginAdmin;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

public interface AccountsProtocol {

    boolean userLogin(LoginUser loginUser);
    boolean registrationUser(RegistrationUser registrationUser);
    boolean loginAdmin(LoginAdmin loginAdmin, boolean allowed);

}
