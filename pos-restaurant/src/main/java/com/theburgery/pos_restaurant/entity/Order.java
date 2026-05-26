package com.theburgery.pos_restaurant.entity;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import com.theburgery.pos_restaurant.entity.enums.OrderStatus;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Builder;

@Entity
@Table(name = "orders")
@Builder
public class Order extends BaseEntity{
    
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id", nullable = false)
    private RestaurantTable table;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30)
    @Builder.Default
    private OrderStatus status = OrderStatus.PENDING;

    @Column(name = "total_amount", nullable = false, precision = 10, scale = 2)
    @Builder.Default
    private BigDecimal totalAmount = BigDecimal.ZERO;

    /**
     * El mappedBy le dice a JPA que Order no es el dueño de la relacion
     * El dueño de la relacion es el atributo order dentro de OrderItem.
     * 
     * Cascade.ALL permite que las operaciones realizadas sobre Order se propaguen 
     * automaticamente a sus items
     * 
     * orphanRemoval Si un OrderItem deja de pertenecer a la coleccion Order, Hibernate
     * lo elimina de la BD
     */
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> items = new ArrayList<>();


    /**
     * Agrega un OrderItem al pedido y sincroniza
     * ambos lados de la relacion bidireccional
     * 
     * Tambien asigna esta orden mediante setORder(this)
     * @param item Item que sera agregado al pedido.
     */
    public void addItem(OrderItem item) {
        items.add(item);
        item.setOrder(this);
    }
}
