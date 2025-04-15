// src/main/java/com/shops/repository/ShopRepository.java
package com.shops.repository;

import com.shops.entity.Shop;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShopRepository extends JpaRepository<Shop, Long> {
}