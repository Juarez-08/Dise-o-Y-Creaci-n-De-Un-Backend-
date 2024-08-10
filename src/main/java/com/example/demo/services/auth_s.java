package com.example.demo.services;

import com.example.demo.dto.auth.autentification;
import com.example.demo.security.serv;
import com.example.demo.user;
import com.example.demo.dto.auth.register;
import com.example.demo.dto.auth.login_user;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.authentication.AuthenticationManager;


@Service
public class auth_s {
    @Autowired
    private user_m userm;

    @Autowired
    private serv serv;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthenticationManager authenticationManager;

    public autentification login(final login_user request){
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUser(), request.getPass()));
        UserDetails user = userm.findByEmail(request.getUser()).orElseThrow();
        String token = serv.getToken(user);
        return new autentification(token);
    }

    public autentification register (final register request) {
        user user = new user();
        user.setName(request.getUser());
        user.setPassword(passwordEncoder.encode(request.getPass()));
        user.setRole(com.example.demo.role.role.USER);

        userm.save(user);
        return new autentification(this.serv.getToken(user));
    }
}
