package com.edusantanaw.crud.product;

import com.edusantanaw.crud.product.DTO.CreateProductDTO;
import com.edusantanaw.crud.product.DTO.UpdateProductDTO;
import com.edusantanaw.crud.product.entity.Product;
import com.edusantanaw.crud.product.helpers.ProductReponse;
import jakarta.validation.Valid;
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
    public ResponseEntity<ProductReponse> create(@RequestBody @Valid CreateProductDTO data){
        var prod = productService.create(data);
        return new ResponseEntity<>(prod, HttpStatus.CREATED);
    }

    @GetMapping
    public  ResponseEntity<Page<Product>> loadProducts(Pageable page){
       Page<Product> products = productService.load(page);
        return  ResponseEntity.ok(products);
    }
    @GetMapping("/{id}")
    public ResponseEntity loadById(@RequestParam UUID id){
      try {
          Product prod = productService.loadById(id);
          return  ResponseEntity.ok(prod);
      } catch (Exception e) {
          return  new ResponseEntity(HttpStatus.NO_CONTENT);
      }
    }
    @PutMapping
    public ResponseEntity updateProduct(@RequestBody @Valid  UpdateProductDTO data){
        try {
            Product updatedProduct = productService.upadteProduct(data);
            return ResponseEntity.ok(updatedProduct);
        }catch (Exception e){
            return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping
    @RequestMapping("/{id}")
    public ResponseEntity deleteProduct(@RequestParam UUID id){
        try {
            productService.removeProduct(id);
            return ResponseEntity.ok(null);
        }catch (Exception e){
            return  new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }
}
