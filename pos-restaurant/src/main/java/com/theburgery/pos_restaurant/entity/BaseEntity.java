package com.theburgery.pos_restaurant.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Data;

/**
 * Se crea la clase Base entity para no replicar codigo, y las demas entidades
 * heredan de esta.
 * MappedSuperclass le dice al JPA que no es una tabla que son atributos que se 
 * inyectan en la herencia
 * Entitylisteners Autoriza a poner automaticamente la fecha y hora de los create y update
 * Y en Application se debe habilitar con la anotaicion @EnableJpaAuditing
 */
@Data
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {
    
    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
