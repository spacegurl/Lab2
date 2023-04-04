package com.example.lab2.data.models;

public class LoginUser {

    private String phone;

    private String password;


    public LoginUser(String phone, String password) {
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
