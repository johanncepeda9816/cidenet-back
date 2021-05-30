package com.cidenet.application.services;

import java.io.IOException;
import java.util.List;

import com.cidenet.application.AppException;
import com.cidenet.application.entities.Email;
import com.cidenet.application.entities.User;

public interface UserServices {
    void registerUser(User user) throws AppException,IOException;
    Email generateEmail(String name, String lastName, String country) throws AppException, IOException;
    List<User> getAllUsers() throws AppException, IOException;
    User findUserByDocument(String document) throws AppException, IOException;
    User findUserByEmail(String email) throws AppException, IOException;
    void editUserInfo(User oldUser, User newUser) throws AppException, IOException;
    void deleteUser(String documentNumber) throws AppException, IOException;
}
