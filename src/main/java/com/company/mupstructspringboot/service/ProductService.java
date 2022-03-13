package com.company.mupstructspringboot.service;


import com.company.mupstructspringboot.dto.ProductDto;
import com.company.mupstructspringboot.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    List<Product> getAllProducts();
    Optional<Product> getProductById(Long id);
    Product postProduct(Product product);
    Product updateProduct(Product product);
    void deleteProductById(Long id);


}
