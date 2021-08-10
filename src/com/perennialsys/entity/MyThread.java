package com.perennialsys.entity;

import com.perennialsys.service.BookService;

import java.util.ArrayList;
import java.util.Scanner;

public class MyThread extends Thread {
    BookService service;

    public MyThread(BookService service) {
        this.service = service;
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        Borrower borrower = new Borrower();
        ArrayList<Book> listOfBooks = new ArrayList<>();
scanner.nextLine();
            System.out.println("Enter the book number");
            book.setIsbn(scanner.nextInt());
            scanner.nextLine();
            System.out.println("Enter the book name");
            book.setName(scanner.nextLine());
scanner.nextLine();

        //book.setDate(new Date());
        book.setHoldRequests(new ArrayList<>());
        book.addNewBook(book);
        listOfBooks.add(book);
        System.out.println("Enter the user id");
        borrower.setId(scanner.nextInt());
        scanner.nextLine();
        System.out.println("Enter the user name");
        borrower.setName(scanner.nextLine());
        borrower.setOnHoldBooks(new ArrayList<>());


        service.issuedBook(borrower, book);
    }

}
