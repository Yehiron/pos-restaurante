package com.theburgery.pos_restaurant.DTO.request;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class OrderItemRequestDTO {
    
    @NotNull(message = "El producto es obligatorio")
    private Long productId;

    @Positive(message = "La cantidad debe ser mayor a cero")
    @NotNull(message = "La cantidad es obligatoria")
    private Integer quantity;

    private String notes;

}
