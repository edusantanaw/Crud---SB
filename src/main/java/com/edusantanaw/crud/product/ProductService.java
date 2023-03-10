package com.edusantanaw.crud.product;

import com.edusantanaw.crud.infra.ProductRepository;
import com.edusantanaw.crud.product.DTO.CreateProductDTO;
import com.edusantanaw.crud.product.DTO.UpdateProductDTO;
import com.edusantanaw.crud.product.entity.Product;
import com.edusantanaw.crud.product.helpers.ProductReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public ProductReponse create(CreateProductDTO data){
        Product product = buildProduct(data);
        repository.save(product);
        return ProductReponse.builder().product(product).build();
    }

    private Product buildProduct(CreateProductDTO data){
        return Product
                .builder()
                .name(data.getName())
                .description(data.getDescription())
                .price(data.getPrice())
                .amount(data.getAmount())
                .build();
    }

    public Page<Product> load(Pageable page){
        var prods = repository.findAll(page);
        return prods;
    }

    public Product loadById(UUID id){
        var prod = repository.findById(id).orElseThrow(() -> new Error("Product not found!"));
        return  prod;
    }

    public  Product upadteProduct(UpdateProductDTO data){
        Product prod = repository.findById(data.getId()).orElseThrow(() ->{
            throw  new Error("Product not exists!");
        });
        repository.save(prod);
        return prod;
    }

    public void removeProduct(UUID id){
        repository.findById(id).orElseThrow(() ->{
            throw  new Error("Product not exists!");
        });
        repository.deleteById(id);
    }
}
