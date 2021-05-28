package com.cidenet.application.services;

import java.util.List;

import com.cidenet.application.entities.User;

public interface UserServices {
    void registerUser(User user);
    void editUserInfo(User user);
    User findUserByDocument(String document);
    User findUserByEmail(String email);
    List<User> getAllUsers();
}
