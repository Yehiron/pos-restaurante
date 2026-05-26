package com.theburgery.pos_restaurant.DTO.response;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemResponseDTO {
    
    private Long id;

    private Long productId;

    private String productName;

    private Integer quantity;

    private BigDecimal unitprice;

    private BigDecimal subTotal;

    private String notes;


}
