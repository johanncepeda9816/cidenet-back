package com.cidenet.application.services.impl;

import java.util.List;

import com.cidenet.application.AppException;
import com.cidenet.application.entities.User;
import com.cidenet.application.repositories.UserRepository;
import com.cidenet.application.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServicesImpl implements UserServices{

    @Autowired
    UserRepository userRepository;

    public void registerUser(User user) throws AppException {
        try {
            user.setModificationDate(user.getRegistrationDate());
            user.setActive(true);
            userRepository.save(user);
        } catch (Exception e) {
            throw new AppException("No se registró el usuario. ERROR: " + e.getMessage());
        }
    }

    public void editUserInfo(User oldUser, User newUser) throws AppException {
        try {
            userRepository.delete(oldUser);
            userRepository.save(newUser);
        } catch (Exception e) {
            throw new AppException("No se pudo editar la informacion del usuario");
        }
    }

    public User findUserByDocument(String documentNumber) throws AppException{
        User user = null;
        try {
            user = userRepository.findByDocumentNumber(documentNumber);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("No se pudo encontrar el usuario con el documento dado: " + documentNumber);
        }

        return user;
    }

    public User findUserByEmail(String email) throws AppException{
        User user = null;
        try {
            user = userRepository.findByEmail(email);
        } catch (Exception e) {
            throw new AppException("No se pudo encontrar el usuario con el correo dado: " + email);
        }

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void deleteUser(String documentNumber) throws AppException {
        try {
            User user = findUserByDocument(documentNumber);
            if(user != null)
                userRepository.delete(user);
            else
                throw new AppException("El usuario: " + documentNumber + " no esta registrado");
        } catch (Exception e) {
            throw new AppException("No se pudo eliminar el usuario. ERROR: " + e.getMessage());
        }
    }    
}
