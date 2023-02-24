package com.edusantanaw.crud.product.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class CreateProductDTO {
    @NotBlank
    @Size(min=3, max = 20)
    private  String name;

    @NotBlank
    @Size(min = 3, max = 250)
    private String description;
    @NotBlank
    private double price;
    @NotBlank
    private int amount;
}
