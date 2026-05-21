package com.theburgery.pos_restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.theburgery.pos_restaurant.entity.Order;
import com.theburgery.pos_restaurant.entity.enums.OrderStatus;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    
    /**
     * Busca una orden por su id y carga sus detalles relacionados, 
     * como el usuario, la mesa y los items del pedido
     * Es el complemento de LAZY, para cargar los detalles de la orden cuando se necesiten
     * y es en lenguaje JPQL que es similar a SQL pero orientado a objetos
     * @param id
     * @return
     */
    @EntityGraph(attributePaths = {"user", "table", "items", "items.product"})
    @Query("SELECT o FROM Order o WHERE o.id = :id")
    Optional<Order> findByIdWithDetails(Long id);

    /**
     * Busca ordenes por el id de la mesa y un estado diferente al dado, esto es 
     * importante para mostrar las ordenes activas de una mesa, y evitar 
     * mostrar las ordenes que ya han sido pagadas o canceladas.
     * @param tableId
     * @param status
     * @return
     */
    List<Order> findByTableIdAndStatusNot(Long tableId, OrderStatus status);
}
