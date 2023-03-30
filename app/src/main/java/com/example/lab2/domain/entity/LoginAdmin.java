package com.example.lab2.domain.entity;

public class LoginAdmin {

    private final String phone;

    private final String password;


    public LoginAdmin(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
