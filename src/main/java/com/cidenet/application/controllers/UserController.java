package com.cidenet.application.controllers;

import java.util.List;

import javax.websocket.server.PathParam;

import com.cidenet.application.AppException;
import com.cidenet.application.entities.User;
import com.cidenet.application.repositories.UserRepository;
import com.cidenet.application.services.UserServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping(value = "api/v1")
public class UserController {

    @Autowired
    UserServices userServices;

    @RequestMapping(method = RequestMethod.POST, path = { "/registerUser" })
    public ResponseEntity<?> registerUser(@RequestBody User user){
        try {
            userServices.registerUser(user);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    @RequestMapping(method = RequestMethod.GET, path = { "/getAllUsers" })
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userServices.getAllUsers();
        System.out.println(users);
        return ResponseEntity.ok().body(users);
	}

    
    @GetMapping("/getUserById")
    public ResponseEntity<User> getUserByDocument(@RequestParam("documentNumber") String documentNumber) throws AppException{
        try {
            User user = userServices.findUserByDocument(documentNumber);
            return ResponseEntity.ok().body(user);

        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
