package com.cidenet.application.services.impl;

import java.util.List;

import com.cidenet.application.entities.User;
import com.cidenet.application.repositories.UserRepository;
import com.cidenet.application.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServicesImpl implements UserServices{

    @Autowired
    UserRepository userRepository;

    public void registerUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editUserInfo(User user) {

    }

    public User findUserByDocument(String documentNumber) {
        User user = null;
        try {
            userRepository.findByDocumentNumber(documentNumber);
        } catch (Exception e) {

        }
        return user;
    }

    public User findUserByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    
}
