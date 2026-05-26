package com.theburgery.pos_restaurant.DTO.request;

import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrderCreateRequestDTO {
    
    @NotNull(message = "El numero de mesa es obligario")
    private Long tableId;

    @NotEmpty(message = "La orden no puede estar vacia")
    private List<OrderItemRequestDTO> items;
}
