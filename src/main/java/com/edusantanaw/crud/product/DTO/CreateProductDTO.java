package com.edusantanaw.crud.product.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;


@Data
public class CreateProductDTO {
    @NotBlank(message = "Name is required!")
    @Size(min=3, max = 20)
    private  String name;

    @NotBlank(message = "Description is required!")
    @Size(min = 3, max = 250)
    private String description;
    @NotNull(message = "Price is required!")
    private double price;
    @NotNull(message = "Amount is required!")
    private int amount;
}
