package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView title = findViewById(R.id.title);
        title.setText(R.string.auth);
        ImageView imageView = findViewById(R.id.imageView);
        imageView.setImageResource(R.drawable.startframe_people_blueprint);
    }
}