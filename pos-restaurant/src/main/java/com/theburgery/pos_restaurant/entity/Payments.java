package com.theburgery.pos_restaurant.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.management.relation.Role;

import org.springframework.data.annotation.CreatedDate;

import com.theburgery.pos_restaurant.entity.enums.PaymentsMethods;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;


@Entity
@Table(name = "payments")
public class Payments {
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne
    @JoinColumn(name = "order_id", nullable = false, unique = true)
    private Order order;
    
    @ManyToOne
    @JoinColumn(name = "cashier_id", nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Enumerated(EnumType.STRING)
    private PaymentsMethods paymentsMethods;

    @Column(name = "amount_paid", nullable = false, precision = 10, scale = 2)
    private BigDecimal amountPaid;

    @CreatedDate
    @Column(name = "payment_date", nullable = false, updatable = false)
    private LocalDateTime paymentDate;
}