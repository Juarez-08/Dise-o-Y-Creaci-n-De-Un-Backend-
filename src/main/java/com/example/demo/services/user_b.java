package com.example.demo.services;

import com.example.demo.dto.user;
import java.util.List;

public interface user_b {
    List<user> getAllElements();
    user getById(String id);
    user save(user user);
    user update(user user, String id);
    void delete(String id);
}
