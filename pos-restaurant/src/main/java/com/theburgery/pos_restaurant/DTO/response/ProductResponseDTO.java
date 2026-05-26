package com.theburgery.pos_restaurant.DTO.response;

import java.math.BigDecimal;
import java.util.Locale.Category;

public class ProductResponseDTO {
    
    private Long id;

    private String categoryName;

    private String name;

    private String description;

    private BigDecimal price;

    private Integer stock;

    private Boolean isActive;


}
