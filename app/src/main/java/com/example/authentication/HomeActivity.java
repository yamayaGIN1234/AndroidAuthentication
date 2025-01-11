package com.example.authentication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    private TextView tvWelcomeMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        tvWelcomeMessage = findViewById(R.id.tvWelcomeMessage);
        tvWelcomeMessage.setText("Chào mừng bạn đến với trang chủ!");
    }
}
