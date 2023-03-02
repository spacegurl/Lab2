package com.example.lab2;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lab2.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
//    ActivityResultLauncher<Intent> startForResult = registerForActivityResult(
//            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
//                @Override
//                public void onActivityResult(ActivityResult result) {
//                    if (result != null && result.getResultCode() == RESULT_OK) {
//                        if (result.getData() != null && result.getData().getStringExtra(MenuActivity.NUMBER) != null) {
//                            binding.enterPhone.setText(result.getData().getStringExtra(MenuActivity.NUMBER).substring(2));
//                            binding.enterPasswd.setText("");
//                        }
//                    }
//                }
//            });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .setReorderingAllowed(true)
                    .add(R.id.fragment_container, StartFrameFragment.class, null)
                    .commit();
        }


//        binding.button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Log.d("my logs", "button clicked");
//                startForResult.launch(MenuActivity.newIntentMenuActivity(MainActivity.this,
//                        binding.enterPhone.getText().toString()));
//            }
//        });
    }


}