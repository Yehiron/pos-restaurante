package com.theburgery.pos_restaurant.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.theburgery.pos_restaurant.entity.RestaurantTable;
import com.theburgery.pos_restaurant.entity.enums.TableStatus;

public interface RestaurantTableRepository extends JpaRepository<RestaurantTable, Long> {
    
    /**
     * Busca una mesa por su numero, esto es importante para evitar 
     * duplicados, y para asignar mesas a los pedidos
     * @param tableNumber
     * @return
     */
    Optional<RestaurantTable> findByTableNumber(Integer tableNumber);

    /**
     * Verifica si una mesa con el numero dado existe
     * @param tableNumber
     * @return
     */
    boolean existsByTableNumber(Integer tableNumber);

    /**
     * Busca mesas por su estado
     * @param status
     * @return
     */
    List<RestaurantTable> findByStatus(TableStatus status);
}
