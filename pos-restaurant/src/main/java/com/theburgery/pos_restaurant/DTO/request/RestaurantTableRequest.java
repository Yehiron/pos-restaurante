package com.theburgery.pos_restaurant.DTO.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public class RestaurantTableRequest {
    
    @Positive(message = "El numero de mesa es obligatorio")
    @NotNull(message = "El numero de mesa debe ser un valor positivo")
    private Integer tableNumber;

    @NotNull(message = "La capacidad es obligatoria")
    @Min(value = 1, message = "La mesa debe tener capacidad para al menos 1 persona")
    private Integer capacity;
}
