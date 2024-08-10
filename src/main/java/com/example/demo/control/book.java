package com.example.demo.control;

import java.util.List;

import com.example.demo.services.book_s;
import com.example.demo.object.book_e;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;

@RestController
@RequestMapping("/api/books")
public class book {
    @Autowired
    private book_s books;
    @GetMapping
    public List<book_e> getAllBooks() {
        return books.getAllBooks();
    }
    @GetMapping("/{id}")
    public book_e getBookById(@PathVariable String id) {
        return books.getBookById(id);
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public book_e createBook(@RequestBody book_e booke) {
        return books.saveBook(booke);
    }
    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteBook(@PathVariable String id) {
        books.deleteBook(id);
    }
}
