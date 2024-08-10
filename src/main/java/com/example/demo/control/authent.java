package com.example.demo.control;

import com.example.demo.dto.auth.register;
import com.example.demo.dto.auth.login_user;
import com.example.demo.services.auth_s;
import com.example.demo.dto.auth.autentification;

import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
@RequestMapping("/auth")
public class authent {
    @Autowired
    private auth_s auts;
    @PostMapping(value = "/login")
    public ResponseEntity<autentification> login(@RequestBody login_user loginuser) {
        autentification autentification = auts.login(loginuser);
        return ResponseEntity.ok(autentification);
    }
    @PostMapping("/register")
    public ResponseEntity<autentification> register(@RequestBody register register) {
        autentification autentification = auts.register(register);
        return ResponseEntity.ok(autentification);
    }
}
