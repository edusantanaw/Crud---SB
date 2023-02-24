package com.edusantanaw.crud.product.helpers;

import com.edusantanaw.crud.product.entity.Product;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductReponse{
        private Product product;
}
