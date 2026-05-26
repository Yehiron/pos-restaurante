package com.theburgery.pos_restaurant.DTO.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CategoryResponseDTO {
    
    private Long id;

    private String name;

    private String description;

    private Boolean isActive;
}
