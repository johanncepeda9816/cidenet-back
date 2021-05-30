package com.cidenet.application.services.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import com.cidenet.application.AppException;
import com.cidenet.application.Log;
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

    /**
     * Permite registrar un nuevo usuario
     * @param user usuario a registrar
     * @throws AppException El usuario ya esta registrado
     * @throws IOException Para manejo de Logs
     */
    public void registerUser(User user) throws AppException, IOException {
        try {
            if (findUserByDocument(user.getDocumentNumber()) != null) {
                Log.addLine("Error agregando al usuario con documento: " + user.getDocumentNumber() + AppException.EL_CORREO_ELECTRONICO_YA_SE_ENCUENTRA_REGISTRADO);
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
            e.printStackTrace();
            Log.addLine("No se registró el usuario. ERROR: " + e.getMessage());
            throw new AppException("No se registró el usuario. ERROR: " + e.getMessage());
        }
    }

    /**
     * Genera un correo electrónico único sin repeticiones y con el dominio especúfico según el país
     * @param name Nombre del usuario
     * @param lastName Apellido del usuario
     * @param country País del usuario
     * @throws AppException
     */
    public Email generateEmail(String name, String lastName, String country) throws AppException, IOException {
        name = name.replaceAll(" ", "");
        lastName = lastName.replaceAll(" ", "");
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

    /**
     * Edita y reemplaza la informacion de un usuario
     * @param oldUser Información almacenada sin cambios
     * @param newUser Información actualizada 
     * @throws AppException
     */
    public void editUserInfo(User oldUser, User newUser) throws AppException, IOException {
        try {
            userRepository.delete(oldUser);
            LocalDateTime now = LocalDateTime.now();
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
            String formatDateTime = now.format(format);
            newUser.setModificationDate(formatDateTime);
            userRepository.save(newUser);
        } catch (Exception e) {
            Log.addLine("No se pudo editar la informacion del usuario. Error:" + e.getMessage());
            throw new AppException("No se pudo editar la informacion del usuario");
        }
    }

    /**
     * Busca un usuario dado su documento de identificación
     * @param documentNumber Numero del documento a buscar
     * @throws AppException
     */
    public User findUserByDocument(String documentNumber) throws AppException, IOException {
        User user = null;
        try {
            user = userRepository.findByDocumentNumber(documentNumber);
        } catch (Exception e) {
            Log.addLine("No se pudo encontrar el usuario con el documento dado: " + documentNumber);
            throw new AppException("No se pudo encontrar el usuario con el documento dado: " + documentNumber);
        }

        return user;
    }

    /**
     * Busca un usuario dada su dirección de correo electrónico
     * @param email Correo electronico a buscar
     * @throws AppException
     */
    public User findUserByEmail(String email) throws AppException, IOException {
        User user = null;
        try {
            user = userRepository.findByEmail(email);
        } catch (Exception e) {
            Log.addLine("No se pudo encontrar el usuario con el correo dado: " + email);
            Log.addLine("ERROR: " + e.getMessage());
            throw new AppException("No se pudo encontrar el usuario con el correo dado: " + email);
        }

        return user;
    }

    /**
     * Obtene una lista de todos los usuarios registrados
     * @throws IOException
     */
    public List<User> getAllUsers() throws IOException {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            Log.addLine("No se pudo obtener la lista de usuarios. ERROR: " + e.getMessage());
            return null;
        }
    }

    /**
     * Elimina un registro en la base de datos
     * @param documentNumber Numero de documento a eliminar
     * @throws AppException
     */
    public void deleteUser(String documentNumber) throws AppException, IOException {
        try {
            User user = findUserByDocument(documentNumber);
            if (user != null){
                userRepository.delete(user);
            }
            else{
                Log.addLine("ELIMINANDO USUARIO");
                Log.addLine("El usuario: " + documentNumber + " no esta registrado");
                throw new AppException("El usuario: " + documentNumber + " no esta registrado");
            }
        } catch (Exception e) {
            Log.addLine("No se pudo eliminar el usuario. ERROR: " + e.getMessage());
            throw new AppException("No se pudo eliminar el usuario. ERROR: " + e.getMessage());
        }
    }
}
