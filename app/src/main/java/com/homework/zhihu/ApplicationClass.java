package com.homework.zhihu;

import android.app.Application;

import java.util.Vector;

public class ApplicationClass extends Application {
    private String password = "";
    private String username = "";

    public String getPassWord() {
        return password;
    }

    public void setPassWord(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
