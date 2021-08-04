package com.perennialsys.entity;

import java.util.List;

public class User {
    static int idNo;
    private Integer id;
    private String name;
    private String contactNo;
    List<User> userList;

    public User() {
    }

    public User(Integer id, String name, String contactNo) {
        idNo++;
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
    }
    public void addNewUser(){

    }

}
