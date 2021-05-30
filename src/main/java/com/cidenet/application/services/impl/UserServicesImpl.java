package com.cidenet.application.services.impl;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cidenet.application.AppException;
import com.cidenet.application.entities.Email;
import com.cidenet.application.entities.User;
import com.cidenet.application.repositories.UserRepository;
import com.cidenet.application.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserServicesImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    public void registerUser(User user) throws AppException {
        try {
            if (findUserByDocument(user.getDocumentNumber()) != null) {
                throw new AppException(AppException.EL_NUMERO_DE_DOCUMENTO_YA_SE_ENCUENTRA_REGISTRADO);
            } else {
                LocalDateTime now = LocalDateTime.now();
                DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
                String formatDateTime = now.format(format);
                user.setModificationDate(formatDateTime);
                user.setRegistrationDate(formatDateTime);
                user.setEmail(generateEmail(user.getFirstName(), user.getFirstSurname(), user.getCountry()).getEmail());
                user.setActive(true);
                if (user.getEnterDate() == null)
                    user.setEnterDate(formatDateTime);

                userRepository.save(user);
            }

        } catch (Exception e) {
            throw new AppException("No se registró el usuario. ERROR: " + e.getMessage());
        }
    }

    public Email generateEmail(String name, String lastName, String country) throws AppException {
        String domain = country.equals("Colombia") ? ".co" : ".us";
        String email = (name.toLowerCase() + "." + lastName.toLowerCase() + "@cidenet.com" + domain);
        if (findUserByEmail(email) == null) {
            return new Email(email);
        } else {
            for (int i = 0; i < getAllUsers().size(); i++) {
                email = (name.toLowerCase() + "." + lastName.toLowerCase() + "." + (i+1) + "@cidenet.com" + domain);
                if (findUserByEmail(email) == null) {
                    return new Email(email);
                }
            }
        }
        return null;
    }

    public void editUserInfo(User oldUser, User newUser) throws AppException {
        try {
            userRepository.delete(oldUser);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatDateTime = now.format(format);
            newUser.setModificationDate(formatDateTime);
            userRepository.save(newUser);
        } catch (Exception e) {
            throw new AppException("No se pudo editar la informacion del usuario");
        }
    }

    public User findUserByDocument(String documentNumber) throws AppException {
        User user = null;
        try {
            user = userRepository.findByDocumentNumber(documentNumber);
        } catch (Exception e) {
            e.printStackTrace();
            throw new AppException("No se pudo encontrar el usuario con el documento dado: " + documentNumber);
        }

        return user;
    }

    public User findUserByEmail(String email) throws AppException {
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
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void deleteUser(String documentNumber) throws AppException {
        try {
            User user = findUserByDocument(documentNumber);
            if (user != null)
                userRepository.delete(user);
            else
                throw new AppException("El usuario: " + documentNumber + " no esta registrado");
        } catch (Exception e) {
            throw new AppException("No se pudo eliminar el usuario. ERROR: " + e.getMessage());
        }
    }
}
