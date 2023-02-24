package com.example.lab2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("my logs", "button clicked");
            }
        });
    }

    public void SingInClick(View view) {
        Log.d("my logs", "button clicked");
    }
}