package com.example.demo.services;

import com.example.demo.object.book_e;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface book_m extends MongoRepository<book_e, String> {
}