package com.perennialsys.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class User {
    static int UUID;
    List<User> userList;
    private Integer id;
    private String name;
    private int contactNo;
    private ArrayList<HoldRequest> onHoldBooks;

    public User() {
    }

    public List<User> getUserList() {
        return userList;
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public User(Integer id, String name, int contactNo) {
        UUID++;
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.onHoldBooks= new ArrayList<>();
    }

    public void addNewUser(User user) {
        this.contactNo = contactNo;
        this.name = name;
        this.id = id;

    }

    public ArrayList<HoldRequest> getOnHoldBooks() {
        return onHoldBooks;
    }

    public User setOnHoldBooks(ArrayList<HoldRequest> onHoldBooks) {
        this.onHoldBooks = onHoldBooks;
        return this;
    }

    public void addHoldRequest(HoldRequest hr) {
        onHoldBooks.add(hr);
    }

    public void removeHoldRequest(HoldRequest hr) {
        onHoldBooks.remove(hr);
    }

}
