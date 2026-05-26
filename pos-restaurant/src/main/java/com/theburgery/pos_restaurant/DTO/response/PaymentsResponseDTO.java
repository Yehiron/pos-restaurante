package com.theburgery.pos_restaurant.DTO.response;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaymentsResponseDTO {
    
    private Long id;

    private Long orderId;
    
    private String cashierName;

    private String paymentMethod;

    private BigDecimal amountPaid;

    private LocalDateTime paymentDate;

}
