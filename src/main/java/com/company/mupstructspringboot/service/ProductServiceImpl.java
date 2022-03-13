package com.company.mupstructspringboot.service;

import com.company.mupstructspringboot.dto.ProductDto;
import com.company.mupstructspringboot.mapper.ProductMapper;
import com.company.mupstructspringboot.model.Product;
import com.company.mupstructspringboot.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> getProductById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public Product postProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        Product product1 = productRepository.findById(product.getId()).get();
        product1.setName(product.getName());
        product1.setQuantity(product.getQuantity());
        product1.setPrice(product.getPrice());
        product1.setDescription(product.getDescription());
        productRepository.save(product1);
        return product1;
    }

    @Override
    public void deleteProductById(Long id) {
       productRepository.deleteById(id);
    }
}
