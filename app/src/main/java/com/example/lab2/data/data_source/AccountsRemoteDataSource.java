package com.example.lab2.data.data_source;

import android.content.Context;

import com.example.lab2.data.models.LoginAdmin;
import com.example.lab2.data.models.LoginUser;
import com.example.lab2.data.models.RegistrationUser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class AccountsRemoteDataSource {

    private final Context context;

    public AccountsRemoteDataSource(Context context) {
        this.context = context;
    }

    public boolean checkLoginValid(LoginUser loginUser){
        String filename = "phone";
        String fileContents = loginUser.getPhone();
        File dir = context.getFilesDir();
        File file_phone = new File(dir, filename);
        try {
            FileOutputStream fos = new FileOutputStream(file_phone); //создаем поток на запись
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos)); // записываем
            writer.write(fileContents);
            writer.close();
            fos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return !loginUser.getPhone().equals("") && !loginUser.getPassword().equals("");
    }

    public boolean checkRegistrationValid(RegistrationUser registrationUser){
        return !registrationUser.getName().equals("") &&
                !registrationUser.getPassword().equals("") &&
                !registrationUser.getPhone().equals("");
    }

    public boolean checkAdminValid(LoginAdmin loginAdmin, boolean allowed){
        if (allowed) {
            String filename = "phone";
            String fileContents = loginAdmin.getPhone();
            File file_login = new File("/storage/emulated/0/Android/data", filename);
            try {
                FileOutputStream fos = new FileOutputStream(file_login);
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
                writer.write(fileContents);
                writer.close();
                fos.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        return !loginAdmin.getPhone().equals("") &&
                !loginAdmin.getPassword().equals("");
    }
}
