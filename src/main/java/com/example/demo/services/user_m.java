package com.example.demo.services;

import com.example.demo.user;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

@Repository
public interface user_m extends MongoRepository<user, String> {
    Optional<user> findByEmail(String email);

}


