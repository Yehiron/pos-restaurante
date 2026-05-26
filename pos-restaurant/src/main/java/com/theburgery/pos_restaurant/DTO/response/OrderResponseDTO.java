package com.theburgery.pos_restaurant.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;

@Data
public class OrderResponseDTO {
    
    private Long id;

    private String waiterName;

    private Integer tableNumber;

    private String status;

    private BigDecimal totalAmount;

    private LocalDateTime createdAt;

    private List<OrderItemResponseDTO> items;
}
