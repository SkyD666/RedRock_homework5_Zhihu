package com.homework.zhihu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnbyUsername = findViewById(R.id.btn_byUsername);
        Button btnbyXinlang = findViewById(R.id.btn_byXinlang);
        Button btnbyTencent = findViewById(R.id.btn_byTencent);
        TextView tvregister = findViewById(R.id.tv_register);
        Toolbar toolbar = findViewById(R.id.toolbar);

        tvregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,Register.class));
            }
        });

        btnbyUsername.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,LoginByUsername.class));
            }
        });

        btnbyTencent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "通过腾讯微博登录",Toast.LENGTH_SHORT).show();
            }
        });

        btnbyXinlang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "通过新浪微博登录",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
