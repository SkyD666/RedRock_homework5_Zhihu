package com.homework.zhihu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

public class Register extends AppCompatActivity{
    /*public static String password = "";
    public static String username = "";*/
    private EditText etpassword;
    private EditText etusername;
    ApplicationClass appClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        appClass = (ApplicationClass)getApplication();
        Toolbar toolbar = findViewById(R.id.toolbar);
        Button btnregister = findViewById(R.id.btn_register);
        etpassword = findViewById(R.id.et_password);
        etusername = findViewById(R.id.et_username);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appClass.setPassWord(etpassword.getText().toString());
                appClass.setUsername(etusername.getText().toString());
                if(TextUtils.isEmpty(appClass.getUsername()) || TextUtils.isEmpty(appClass.getPassWord())){
                    Toast.makeText(getApplicationContext(), "用户名和密码不能为空",Toast.LENGTH_SHORT).show();
                }else if(appClass.getUsername().length()>10){
                    Toast.makeText(getApplicationContext(), "账号不能超过10个字符，请重新输入",Toast.LENGTH_SHORT).show();
                    appClass.setUsername("");
                }else if(appClass.getPassWord().length()>20){
                    Toast.makeText(getApplicationContext(), "密码不能超过20个字符，请重新输入",Toast.LENGTH_SHORT).show();
                    appClass.setPassWord("");
                }else{
                    SharedPreferences.Editor editor = getSharedPreferences("AccountData", MODE_PRIVATE).edit();
                    editor.putString("UserName",appClass.getUsername());
                    editor.putString("Password",appClass.getPassWord());
                    editor.apply();
                    Toast.makeText(getApplicationContext(), "注册成功",Toast.LENGTH_SHORT).show();

                    startActivity(new Intent(Register.this,LoginByUsername.class));
                    finish();
                }
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
