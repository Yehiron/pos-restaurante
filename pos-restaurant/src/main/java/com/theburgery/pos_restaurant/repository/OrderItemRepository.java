package com.theburgery.pos_restaurant.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.theburgery.pos_restaurant.entity.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
    
    /**
     * Busca los OrderItems asociados a un producto especifico, 
     * esto es importante para calcular
     * @param productId
     * @return
     */
    List<OrderItem> findByProduct(Long productId);

    /**
     *  Calcula el ingreso total generado por un producto sumando 
     * los subtotales de los OrderItems asociados a ese producto.
     * @param productId
     * @return
     */
    @Query("SELECT SUM(i.subtotal) FROM OrderItem i WHERE i.product.id = :productId")
    Double calculateTotalRevenueByProduct(@Param("productId") Long productId);
}
