package com.theburgery.pos_restaurant.repository;

import java.util.List;

import org.springframework.boot.data.autoconfigure.web.DataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.theburgery.pos_restaurant.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
    
    /**
     * Busca productos por categoria mediante un id 
     * @param categoryId
     * @return
     */
    List<Product> findByCategoryId(Long categoryId);

    /**
     * Busca un producto por nombre
     */
    List<Product> findByNameContainingIgnoreCase(String name);

    /**
     * Busca productos con stock mayor a un valor dado
     * @param stock
     * @param pageable
     * @return
     */
    Page<Product> findByStockGreaterThan(Integer stock, Pageable pageable);

    /**
     * Realiza una eliminacion logica de un producto, cambiando su estado a inactivo
     * @param id
     */
    @Modifying
    @Query("UPDATE Product p SET p.isActive = false WHERE p.id = :id")
    void softDeleteById(@Param("id") Long id);

}
