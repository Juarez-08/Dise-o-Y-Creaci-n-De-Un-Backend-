package com.example.demo.dto;

public class user {
    private String id;
    private String user;
    private String pass;
    private com.example.demo.role.role roll;

    public user(String id, String user, String pass, com.example.demo.role.role roll) {
        this.id = id;
        this.user = user;
        this.pass = pass;
        this.roll = roll;
    }

    public user(Object id, String user) {
    }

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
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

    public com.example.demo.role.role getRoll() {
        return roll;
    }
    public void setRoll(com.example.demo.role.role roll) {
        this.roll = roll;
    }
}
