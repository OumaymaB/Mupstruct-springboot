package com.company.mupstructspringboot.repository;

import com.company.mupstructspringboot.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
