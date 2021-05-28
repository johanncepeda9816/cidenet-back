package com.cidenet.application.services.impl;

import com.cidenet.application.entities.User;
import com.cidenet.application.services.UserServices;

import org.springframework.stereotype.Component;

@Component
public class UserServicesImpl implements UserServices{

    public void registerUser(User user) {
        try {
            System.out.println(user);
        } catch (Exception e) {
            throw e;
        }
    }

    public void editUserInfo(User user) {

    }

    public User findUserByDocument(String document) {

        return null;
    }

    public User findUserByEmail(String email) {
        return null;
    }
    
}
