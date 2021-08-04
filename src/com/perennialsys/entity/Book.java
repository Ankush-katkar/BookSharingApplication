package com.perennialsys.entity;

import com.perennialsys.Owner;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class Book {
    private long isbn;
    private String name;
    private Set<String> authors;
    private boolean isTaken;
    private List<HoldRequest> holdRequests;
    private Owner owner;
    private Date date;

    public Date getDate() {
        return date;
    }

    public Book setDate(Date date) {
        this.date = date;
        return this;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public Book() {
    }

    public long getIsbn() {
        return isbn;
    }

    public void setIsbn(long isbn) {
        this.isbn = isbn;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;

    }

    public List<HoldRequest> getHoldRequests() {
        return holdRequests;
    }

    public void setHoldRequests(List<HoldRequest> holdRequests) {
        this.holdRequests = holdRequests;

    }

    public void addNewBook(Book book) {
        this.isbn = book.isbn;
        this.name = book.name;
    }

    public void displayBooks(ArrayList<Book> arr) {
        for (Book book : arr) {
            System.out.println("__________________________________________________________");
            System.out.println("BookId\t\t\t\tBookName\t\t\t\tBookAuthor\t\t\t\tDate added\t\t\t\t");
            System.out.println(book.isbn + "\t\t\t\t" + book.name + "\t\t\t\t" + book.authors + "\t\t\t\t" + book.date);
            System.out.println("__________________________________________________________");

        }
    }


}