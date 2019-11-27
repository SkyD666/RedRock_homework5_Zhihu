package com.homework.zhihu;

import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Date;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Logined extends AppCompatActivity {
    private List<AccData> accData = new ArrayList<>();
    ApplicationClass appClass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logined);
        appClass = (ApplicationClass)getApplication();

        initFruits();

        Toolbar toolbar = findViewById(R.id.toolbar);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);

        //recyclerview.addItemDecoration(appClass.getUsername());
        RecyclerView recyclerView = findViewById(R.id.rv_accountData);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);

        recyclerView.setLayoutManager(layoutManager);
        MyRecyclerView adapter = new MyRecyclerView(accData);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if(item.getItemId()==android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    private void initFruits(){
        AccData accData1 = new AccData("用户名：" + appClass.getUsername(),"密码：" + appClass.getPassWord());
        accData.add(accData1);
        SimpleDateFormat nowdate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        accData1 = new AccData("登录时间：",nowdate.format(new Date()));
        accData.add(accData1);
    }
}
