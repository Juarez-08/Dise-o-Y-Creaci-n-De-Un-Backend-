package com.example.demo.object;

import java.time.LocalDate;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "loans")
public class loan_e {
    @Id
    private String id;
    private String bookId;
    private String userId;
    private LocalDate date;
    private LocalDate returnD;
    private boolean flag;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getBookId() {
        return bookId;
    }
    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }
    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalDate getReturnD() {
        return returnD;
    }
    public void setReturnD(LocalDate returnD) {
        this.returnD = returnD;
    }

    public boolean isFlag() {
        return flag;
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
