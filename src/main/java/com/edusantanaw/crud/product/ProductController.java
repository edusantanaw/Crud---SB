package com.edusantanaw.crud.product;


import com.edusantanaw.crud.product.DTO.CreateProductDTO;
import com.edusantanaw.crud.product.entity.Product;
import com.edusantanaw.crud.product.helpers.ProductReponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(path="/api/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ProductReponse> create(@RequestBody CreateProductDTO data){
        var prod = productService.create(data);
        return new ResponseEntity(prod, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<Page<Product>> loadProducts(Pageable page){
       Page<Product> products = productService.load(page);
        return  ResponseEntity.ok(products);
    }
    @GetMapping
    @RequestMapping("/{id}")
    public ResponseEntity loadById(@RequestParam UUID id){
      try {
          var prod = productService.loadById(id);
          return  ResponseEntity.ok(prod);
      } catch (Exception e) {
          return  new ResponseEntity(HttpStatus.NO_CONTENT);
      }
    }

}
