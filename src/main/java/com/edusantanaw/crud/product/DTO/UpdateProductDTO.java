package com.edusantanaw.crud.product.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class UpdateProductDTO extends CreateProductDTO {
    private UUID id;

}
