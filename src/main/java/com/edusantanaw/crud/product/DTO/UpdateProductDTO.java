package com.edusantanaw.crud.product.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class UpdateProductDTO extends CreateProductDTO {
    private UUID id;

}
