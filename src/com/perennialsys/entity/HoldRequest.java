package com.perennialsys.entity;

import java.util.Date;

public class HoldRequest {
    Borrower borrower;
    Book book;
    Date requestDate;

    public HoldRequest(Borrower bor, Book b, Date reqDate) {
        borrower = bor;
        book = b;
        requestDate = reqDate;
    }

    public Borrower getBorrower() {
        return borrower;
    }

    public void setBorrower(Borrower borrower) {
        this.borrower = borrower;

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(Date requestDate) {
        this.requestDate = requestDate;

    }
}
