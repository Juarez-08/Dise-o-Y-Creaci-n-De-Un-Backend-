package com.example.demo.services;

import java.util.List;
import java.time.LocalDate;

import com.example.demo.object.loan_e;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class loan_s {
    @Autowired
    private loan_m loans;

    public List<loan_e> getAllLoans() {
        return loans.findAll();
    }

    public loan_e getLoanById(String id) {
        return loans.findById(id).orElse(null);
    }

    public loan_e createLoan(loan_e loane) {
        loane.setDate(LocalDate.now());
        loane.setFlag(false);
        return loans.save(loane);
    }

    public void returnLoan(String id) {
        loan_e loane = loans.findById(id).orElse(null);
        if (loane != null) {
            loane.setFlag(true);
            loane.setReturnD(LocalDate.now());
            loans.save(loane);
        }
    }

    public void deleteLoan(String id) {
        loans.deleteById(id);
    }
}
