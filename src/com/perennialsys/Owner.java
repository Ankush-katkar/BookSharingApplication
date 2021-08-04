package com.perennialsys;
import com.perennialsys.entity.Book;

import java.util.ArrayList;

public class Owner {

    private int id;
    private String name;
    private String email;
    private Book book;

    public int getId() {
        return id;
    }

    public void  setId(int id) {
        this.id = id;

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;

    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;

    }
}
