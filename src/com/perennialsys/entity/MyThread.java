package com.perennialsys.entity;

import com.perennialsys.service.BookService;

public class MyThread extends Thread {
    BookService service;
    Borrower borrower = new Borrower();
    Book book;

    public MyThread(BookService service, Borrower borrower, Book book) {
        this.service = service;
        this.book = book;
    }

    public void run() {

        service.issuedBook(borrower, book);

    }

}
