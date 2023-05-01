package com.example.lab2.data.data_source;

import android.content.Context;

import androidx.work.Data;
import androidx.work.OneTimeWorkRequest;
import androidx.work.WorkManager;

import com.example.lab2.PhoneWorker;
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

    private final WorkManager workManager;

    public AccountsRemoteDataSource(Context context) {
        this.context = context;

        workManager = WorkManager.getInstance(context);
    }

    private Data createInputData(String phone){
        Data.Builder builder = new Data.Builder();
        builder.putString(PhoneWorker.KEY_PHONE, phone);
        return builder.build();
    }

    public boolean checkLoginValid(LoginUser loginUser){
        OneTimeWorkRequest workRequest =
                new OneTimeWorkRequest.Builder(PhoneWorker.class)
                        .setInputData(createInputData(loginUser.getPhone())).build();
        workManager.enqueue(workRequest);

        return !loginUser.getPhone().equals("") && !loginUser.getPassword().equals("");
    }

    public boolean checkRegistrationValid(RegistrationUser registrationUser){
        return !registrationUser.getName().equals("") &&
                !registrationUser.getPassword().equals("") &&
                !registrationUser.getPhone().equals("");
    }

    public boolean checkAdminValid(LoginAdmin loginAdmin, boolean allowed){
//        if (allowed) {
//            String filename = "phone";
//            String fileContents = loginAdmin.getPhone();
//            File file_login = new File("/storage/emulated/0/Android/data", filename);
//            try {
//                FileOutputStream fos = new FileOutputStream(file_login);
//                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
//                writer.write(fileContents);
//                writer.close();
//                fos.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
        return !loginAdmin.getPhone().equals("") &&
                !loginAdmin.getPassword().equals("");
    }
}
