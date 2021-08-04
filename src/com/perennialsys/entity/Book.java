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
    private boolean isTaken= false;

    private Owner owner;




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

    public Book(long isbn, String name, Set<String> authors, boolean isTaken, Owner owner, Date date) {
        this.isbn = isbn;
        this.name = name;
        this.authors = authors;
        this.isTaken = isTaken;

        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Book{" +
                "isbn=" + isbn +
                ", name='" + name + '\'' +
                ", authors=" + authors +
                ", isTaken=" + isTaken +
                ", owner=" + owner +
                '}';
    }







}