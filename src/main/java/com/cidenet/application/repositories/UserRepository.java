package com.cidenet.application.repositories;

import com.cidenet.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String>{
    User findByDocumentNumber(String documentNumber);
    User findByEmail(String email);
}
