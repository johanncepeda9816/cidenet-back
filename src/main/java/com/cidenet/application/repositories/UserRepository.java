package com.cidenet.application.repositories;

import com.cidenet.application.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositorio para los servicios de usuario
 */
@Repository
public interface UserRepository extends JpaRepository<User, String>{
    
    /**
     * Encuentra un usuario dado su documento de identidad
     * @param documentNumber
     * @return Usuario. Si existe
     */
    User findByDocumentNumber(String documentNumber);

    /**
     * Encuentra un usuario dado su correo electrónico
     * @param email
     * @return Usuario. Si existe
     */
    User findByEmail(String email);
}
