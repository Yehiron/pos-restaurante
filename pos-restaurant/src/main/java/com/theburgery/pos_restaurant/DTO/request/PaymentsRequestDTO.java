package com.theburgery.pos_restaurant.DTO.request;

import java.math.BigDecimal;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;


public class PaymentsRequestDTO {
    
    @NotNull(message = "El ID de la orden es obligatorio")
    private Long orderId;

    @NotBlank(message = "El metodo de pago es obligatorio")
    private String paymentMethod;

    @Positive(message = "El monto a pagar debe ser mayor a cero")
    @NotNull(message = "El monto a pagar es obligatorio")
    private BigDecimal amountPaid;
}
