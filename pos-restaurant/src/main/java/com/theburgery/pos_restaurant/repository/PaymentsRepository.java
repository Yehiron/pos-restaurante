package com.theburgery.pos_restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theburgery.pos_restaurant.entity.Payments;

public interface PaymentsRepository extends JpaRepository<Payments, Long> {
    
}
