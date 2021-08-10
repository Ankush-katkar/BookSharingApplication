package com.perennialsys.entity;
import java.util.ArrayList;
import java.util.Date;
import java.util.Set;
public class Book {
    public String name;
    public boolean isTaken;
    public ArrayList<HoldRequest> holdRequests;
    private long isbn;
    private Set<String> authors;
    public Book() {
    }
    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", isTaken=" + isTaken +
                ", holdRequests=" + holdRequests +
                ", isbn=" + isbn +
                ", authors=" + authors +

                '}';
    }

    public Book(long isbn, String name, Set<String> authors, boolean taken) {
        this.isbn = isbn;
        this.name = name;
        this.authors = authors;
        this.isTaken = taken;
        this.holdRequests=new ArrayList<>();

    }

    public ArrayList<HoldRequest> getHoldRequests() {
        return holdRequests;
    }

    public void setHoldRequests(ArrayList<HoldRequest> holdRequests) {
        this.holdRequests = holdRequests;

    }

    @Override
    public int hashCode() {
        return super.hashCode();
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

    public boolean isTaken() {
        return isTaken;
    }

    public void setTaken(boolean taken) {
        isTaken = taken;
    }

    public Set<String> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<String> authors) {
        this.authors = authors;

    }

    public void addNewBook(Book book) {
        this.isbn = book.isbn;
        this.name = book.name;
    }


}