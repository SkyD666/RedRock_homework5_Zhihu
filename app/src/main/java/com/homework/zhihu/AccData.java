package com.homework.zhihu;

public class AccData {
    private String username;
    private String password;
    public AccData(String username,String password){
        this.username = username;
        this.password = password;
    }
    public String getUserName(){
        return username;
    }
    public String getPassword(){
        return password;
    }
}
