package com.example.authentication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.example.sqlite.DatabaseHandler;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etUsername, etPassword;
    private Button btnRegister, btnLogin;
    private TextView tvMessage;
    private com.example.sqlite.DatabaseHandler databaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ánh xạ view
        etUsername = findViewById(R.id.etUsername);
        etPassword = findViewById(R.id.etPassword);
        btnRegister = findViewById(R.id.btnRegister);
        btnLogin = findViewById(R.id.btnLogin);
        tvMessage = findViewById(R.id.tvMessage);

        // Khởi tạo DatabaseHandler
        databaseHandler = new DatabaseHandler(this);

        // Xử lý nút Đăng ký
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    tvMessage.setText("Vui lòng nhập đầy đủ thông tin!");
                } else {
                    boolean success = databaseHandler.registerUser(username, password);
                    if (success) {
                        tvMessage.setText("Đăng ký thành công!");
                    } else {
                        tvMessage.setText("Tên người dùng đã tồn tại!");
                    }
                }
            }
        });

        // Xử lý nút Đăng nhập
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if (username.isEmpty() || password.isEmpty()) {
                    tvMessage.setText("Vui lòng nhập đầy đủ thông tin!");
                } else {
                    boolean exists = databaseHandler.checkUser(username, password);
                    if (exists) {
                        // Đăng nhập thành công, chuyển đến trang Home
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                        finish(); // Đóng MainActivity để không quay lại màn hình đăng nhập
                    } else {
                        tvMessage.setText("Sai tên người dùng hoặc mật khẩu!");
                    }
                }
            }
        });
    }
}
