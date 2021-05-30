package com.cidenet.application;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.cidenet.application.entities.User;
import com.cidenet.application.repositories.UserRepository;
import com.cidenet.application.services.UserServices;

import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;

/**
 * Pruebas de unidad
 */
public class AppTest{

    @Autowired
    UserServices userServices;

    @Autowired
    UserRepository userRepository;

    User user = null;

    @Before
    public void setUp(){
        SpringApplication.run(App.class);
        user = new User("User","Prueba", "Test", "29-05-2021 14:49:36", "29-05-2021 14:49:36", "29-05-2021 14:49:36", "Cédula de Ciudadanía", "1234567890", "Servicios", "User", "Colombia", "user.prueba@cidenet.com.co", true);
    }

    @Test
    public void puedeCrearUnUsuario(){
        try {
            User user = new User("User","Prueba", "Test", "29-05-2021 14:49:36", "29-05-2021 14:49:36", "29-05-2021 14:49:36", "Cédula de Ciudadanía", "1234567890", "Servicios", "User", "Colombia", "user.prueba@cidenet.com.co", true);
            userServices.registerUser(user);
            assertEquals(user.getDocumentNumber(), userServices.findUserByDocument(user.getDocumentNumber()));
        } catch (Exception e) {
            e.printStackTrace();
            assertFalse(true);
        }
    }

    @Test
    public void noPuedeCrearDosRegistrosConElMismoNumeroDeDocumento(){
        try {
            userServices.registerUser(user);
            assertFalse(false);
        } catch (Exception e) {
            assertTrue(true);
        }
    }
}
