package com.company.mupstructspringboot.controller;

import com.company.mupstructspringboot.dto.ProductDto;
import com.company.mupstructspringboot.mapper.ProductMapper;
import com.company.mupstructspringboot.model.Product;
import com.company.mupstructspringboot.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@AllArgsConstructor
@RequestMapping("/v1/products")
public class ProductController {

    private ProductService service;
    private ProductMapper mapper;

    @GetMapping
    public ResponseEntity<List<ProductDto>> getAllProducts(){
        return ResponseEntity.ok(mapper.modelsToDtos(service.getAllProducts()));
    }

    @PostMapping
    public ResponseEntity<ProductDto> createProduct(@RequestBody ProductDto productDto){
        service.postProduct(mapper.dtoToProduct(productDto));
       return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> getProductById(@PathVariable Long id){
        Optional<Product> product = service.getProductById(id);
        return ResponseEntity.ok(mapper.modelToDto(product.get()));
    }

    @PutMapping
    public ResponseEntity<ProductDto> updateProduct(@RequestBody ProductDto productDto){
        Product product = service.updateProduct(mapper.dtoToProduct(productDto));
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(mapper.modelToDto(product));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProduct(@PathVariable Long id){
        service.deleteProductById(id);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

}
