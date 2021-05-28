package com.cidenet.application.services;

import com.cidenet.application.entities.User;

public interface UserServices {
    void registerUser(User user);
    void editUserInfo(User user);
    User findUserByDocument(String document);
    User findUserByEmail(String email);
}
