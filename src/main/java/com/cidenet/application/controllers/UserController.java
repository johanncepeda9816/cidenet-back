package com.cidenet.application.controllers;

import java.util.List;

import com.cidenet.application.AppException;
import com.cidenet.application.entities.Email;
import com.cidenet.application.entities.User;
import com.cidenet.application.entities.UserList;
import com.cidenet.application.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Clase contenedora de los End-points para los servicios del usuario
 * @Author Johann Cepeda
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1")
public class UserController {

    @Autowired
    UserServices userServices;

    /**
     * Permite registrar un nuevo usuario en la base de datos
     * @param user Usuario a registrar
     * @return Estado de la operacion
     */
    @RequestMapping(method = RequestMethod.POST, path = { "/registerUser" })
    public ResponseEntity<String> registerUser(@RequestBody User user){
        try {
            userServices.registerUser(user);
            return new ResponseEntity<String>("Creado", HttpStatus.OK);
        } catch (Exception e) {
            System.out.print(e.getMessage());
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @RequestMapping(method = RequestMethod.GET, path = { "/generateEmail" })
    public Email generateEmail(@RequestParam("name") String name, @RequestParam("lastName") String lastName, @RequestParam("country") String country){
        try {
            return userServices.generateEmail(name, lastName, country);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }        
    }

    /**
     * Busca todos los usuarios registrados en el sistema
     * @return Lista de usuarios en el sistema
     */
    @RequestMapping(method = RequestMethod.GET, path = { "/getAllUsers" })
	public ResponseEntity<List<User>> getAllUsers() {
        try {
            List<User> users = userServices.getAllUsers();
            return ResponseEntity.ok().body(users);
            
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
	}

    /**
     * Permite buscar un usuario dado su numero de identificación
     * @param documentNumber Numero a buscar
     * @return Usuario si existe
     * @throws AppException
     */
    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserByDocument(@RequestParam("documentNumber") String documentNumber) throws AppException{
        try {
            User user = userServices.findUserByDocument(documentNumber);
            return ResponseEntity.ok().body(user);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Permite buscar un usuario dado su correo electrónico
     * @param email Correo a buscar
     * @return Usuario si existe
     */
    @GetMapping("/getUserByEmail")
    public ResponseEntity<User> getUserByEmail(@RequestParam("email") String email){
        try {
            User user = userServices.findUserByEmail(email);
            return ResponseEntity.ok().body(user);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * Edita la información completa de un usuario
     * @param users Arreglo de dos posiciones con la informacion antigua y la nueva
     * @return Resultado de la operación
     */
    @RequestMapping(method = RequestMethod.POST, path = { "/editUser" })
    public ResponseEntity<?> editUser(@RequestBody UserList users){
        try {
            userServices.editUserInfo(users.getUsers().get(0), users.getUsers().get(1));
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/deleteUser")
    public ResponseEntity<?> deleteUser(@RequestParam("documentNumber") String documentNumber){
        try {
            userServices.deleteUser(documentNumber);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
