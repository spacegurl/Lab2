package com.example.lab2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2.databinding.ActivityMenuBinding;

public class MenuActivity extends AppCompatActivity {
    private ActivityMenuBinding binding;
    private String number = "";
    public static final String NUMBER = "number";
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMenuBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        getExtraIntent();
    }

    public static Intent newIntentMenuActivity(Context context, String phone) {
        Intent intent = new Intent(context, MenuActivity.class);
        intent.putExtra(NUMBER, "+7"+phone);
        return intent;
    }

    private void getExtraIntent(){
        if (!getIntent().hasExtra(NUMBER)){
            throw new RuntimeException("Exception: putExtra(NUMBER, phone) not found");
        }
        number = getIntent().getStringExtra(NUMBER);
        binding.number.setText(number);
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra(NUMBER, number);
        setResult(RESULT_OK, intent);
        finish();
        super.onBackPressed();
    }
}
