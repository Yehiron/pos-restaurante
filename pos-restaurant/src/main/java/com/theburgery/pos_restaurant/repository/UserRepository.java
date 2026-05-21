package com.theburgery.pos_restaurant.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.theburgery.pos_restaurant.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

    /**
     * Busca un usuario por su email y verifica que este activo,
     *  esto es importante para evitar
     * @param email
     * @return
     */
    Optional<User> findByEmailAndIsActiveTrue(String email);

    /**
     * Verifica si un usuario con el email dado existe y esta activo, 
     * esto es importante para evitar
     * @param email
     * @return
     */
    boolean existsByEmail(String email);
    
} 