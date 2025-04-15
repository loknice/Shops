// src/main/java/com/shops/repository/ProductRepository.java
package com.shops.repository;

import com.shops.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}