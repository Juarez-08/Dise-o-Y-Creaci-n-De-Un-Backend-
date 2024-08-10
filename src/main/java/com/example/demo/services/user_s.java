package com.example.demo.services;

import com.example.demo.dto.user;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.stream.Collectors;
import java.util.Optional;
import java.util.List;

@Service
public class user_s implements user_b {
    @Autowired
    private final user_m userm;

    public user_s(user_m userm) {
        this.userm = userm;
    }

    @Override
    public List<user> getAllElements() {
        List<com.example.demo.user> users = userm.findAll();
        return users.stream().map(this::convertToDto).collect(Collectors.toList());
    }

    @Override
    public user getById(String id) {
        com.example.demo.user user = userm.findById(id).orElse(null);
        return convertToDto(user);
    }

    @Override
    public user save(user userDto) {
        validateUserDto(userDto);
        com.example.demo.user user = convertToEntity(userDto);
        user = userm.save(user);
        return convertToDto(user);
    }

    @Override
    public user update(user user, String id) {
        validateUserDto(user);
        Optional<com.example.demo.user> existingUserOptional = userm.findById(id);
        if (existingUserOptional.isPresent()) {
            com.example.demo.user existingUser = existingUserOptional.get();
            updateUserDetails(existingUser, user);
            com.example.demo.user updatedUser = userm.save(existingUser);
            return convertToDto(updatedUser);
        } else {
            return null;
        }
    }

    @Override
    public void delete(String id) {
        userm.deleteById(id);
    }

    public user getByEmail(String email) {
        Optional<com.example.demo.user> user = userm.findByEmail(email);
        return user.map(this::convertToDto).orElse(null);
    }

    public void deleteAll() {
        userm.deleteAll();
    }

    private void validateUserDto(user user) {
        if (user == null || user.getUser() == null) {
            throw new IllegalArgumentException("Error");
        }
    }

    private void updateUserDetails(com.example.demo.user existingUser, user user) {
        existingUser.setName(user.getUser());
        existingUser.setPassword(user.getPass());
        existingUser.setRole(user.getRoll());
    }

    private com.example.demo.user convertToEntity(user user) {
        return new com.example.demo.user(
                user.getId(),
                user.getUser(),
                user.getPass(),
                user.getRoll()
        );
    }

    private user convertToDto(com.example.demo.user user) {
        if (user == null) return null;
        return new user(
                user.getId(),
                user.getName(),
                user.getPassword(),
                user.getRole()
        );
    }
}

