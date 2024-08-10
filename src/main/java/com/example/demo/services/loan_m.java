package com.example.demo.services;

import com.example.demo.object.loan_e;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface loan_m extends MongoRepository<loan_e, String> {
}
