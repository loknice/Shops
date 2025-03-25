// src/main/java/com/shops/repository/PurchaseRepository.java
package com.shops.repository;

import com.shops.entity.Purchase;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PurchaseRepository extends JpaRepository<Purchase, Long> {
}