package com.theburgery.pos_restaurant.DTO.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoryRequestDTO {
    
    @NotBlank(message = "El nombre de la categoria es obligatorio")
    @Size(min = 2)
    private String name;

    @Size(min = 10, max = 255)
    private String description;

}
