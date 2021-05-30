package com.cidenet.application.entities;

import java.util.List;

public class UserList {
    private List<User> users;

    public UserList() {
        
    }

    public UserList(List<User> users) {
        this.users = users;
    }

    public List<User> getUsers() {
        return this.users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "{" +
            " users='" + getUsers() + "'" +
            "}";
    }

}
