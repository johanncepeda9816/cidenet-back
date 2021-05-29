package com.cidenet.application.services;

import java.util.List;

import com.cidenet.application.AppException;
import com.cidenet.application.entities.User;

public interface UserServices {
    void registerUser(User user) throws AppException;
    List<User> getAllUsers() throws AppException;
    User findUserByDocument(String document) throws AppException;
    User findUserByEmail(String email) throws AppException;
    void editUserInfo(User oldUser, User newUser) throws AppException;
    void deleteUser(String documentNumber) throws AppException;
}
