package com.example.demo.dto.auth;

public class login_user {
    private String user;
    private String pass;
    public login_user(String user, String pass) {
        this.user = user;
        this.pass = pass;
    }
    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
