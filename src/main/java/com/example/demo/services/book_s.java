package com.example.demo.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.example.demo.object.book_e;

@Service
public class book_s {
    @Autowired
    private book_m books;

    public List<book_e> getAllBooks() {
        return books.findAll();
    }
    public book_e getBookById(String id) {
        return books.findById(id).orElse(null);
    }
    public book_e saveBook(book_e booke) {
        return books.save(booke);
    }
    public void deleteBook(String id) {
        books.deleteById(id);
    }
}
