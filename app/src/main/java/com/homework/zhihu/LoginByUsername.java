package com.homework.zhihu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;

import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginByUsername extends AppCompatActivity {
    /*public static String password = "";
    public static String username = "";*/
    ApplicationClass appClass;
    private EditText etpassword;
    private EditText etusername;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_by_username);
        appClass = (ApplicationClass)getApplication();

        Toolbar toolbar = findViewById(R.id.toolbar);
        Button btnlogin = findViewById(R.id.btn_login);
        etpassword = findViewById(R.id.et_password);
        etusername = findViewById(R.id.et_username);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                appClass.setPassWord(etpassword.getText().toString());
                appClass.setUsername(etusername.getText().toString());
                if(TextUtils.isEmpty(appClass.getUsername())||TextUtils.isEmpty(appClass.getPassWord())) {
                    Toast.makeText(getApplicationContext(), "用户名和密码不能为空", Toast.LENGTH_SHORT).show();
                }else if(appClass.getUsername().length()>10){
                    Toast.makeText(getApplicationContext(), "账号不能超过10个字符，请重新输入",Toast.LENGTH_SHORT).show();
                    appClass.setUsername("");
                }else if(appClass.getPassWord().length()>20){
                    Toast.makeText(getApplicationContext(), "密码不能超过20个字符，请重新输入",Toast.LENGTH_SHORT).show();
                    appClass.setPassWord("");
                }else{
                    SharedPreferences pref = getSharedPreferences("AccountData", MODE_PRIVATE);
                    appClass.setUsername(pref.getString("UserName",""));
                    appClass.setPassWord(pref.getString("Password",""));
                    if((etpassword.getText().toString().equals(appClass.getPassWord())) && (etusername.getText().toString().equals(appClass.getUsername()))){
                        Toast.makeText(getApplicationContext(), "登录成功", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(LoginByUsername.this,Logined.class));
                        finish();
                    }else{
                        Toast.makeText(getApplicationContext(), "用户名或密码错误", Toast.LENGTH_SHORT).show();
                    }
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
