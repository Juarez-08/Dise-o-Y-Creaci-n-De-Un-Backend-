package com.example.demo.control;

import java.util.List;

import com.example.demo.object.loan_e;
import com.example.demo.services.loan_s;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

@RestController
@RequestMapping("/api/loans")
public class loan {
    @Autowired
    private loan_s loans;
    @GetMapping
    public List<loan_e> getAllLoans() {
        return loans.getAllLoans();
    }
    @PostMapping
    public loan_e createLoan(@RequestBody loan_e loane) {
        return loans.createLoan(loane);
    }
    @PostMapping("/return/{id}")
    public void returnLoan(@PathVariable String id) {
        loans.returnLoan(id);
    }
    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable String id) {
        loans.deleteLoan(id);
    }
}
