package com.example.demo.dto.auth;

public class autentification {
    private String tkn;
    public autentification(String tkn) {
        this.tkn = tkn;
    }
    public String getTkn() {
        return tkn;
    }
    public void setTkn(String tkn) {
        this.tkn = tkn;
    }
}
