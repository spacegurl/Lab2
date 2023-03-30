package com.example.lab2.domain.entity;

public class RegistrationUser {

    private final String name;
    private final String phone;
    private final String password;


    public RegistrationUser(String name, String phone, String password) {
        this.name = name;
        this.phone = phone;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }
}
