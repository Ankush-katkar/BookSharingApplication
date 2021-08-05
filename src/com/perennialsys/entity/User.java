package com.perennialsys.entity;

import java.util.List;

public abstract class User {
    static int idNo;
    private Integer id;
    private String name;
    private String contactNo;
    List<User> userList;

    public User() {
    }

    public User(Integer id, String name, String contactNo) {

        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
    }
    public void addNewUser(){

    }

}
