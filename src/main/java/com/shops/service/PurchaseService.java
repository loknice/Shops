// src/main/java/com/shops/service/PurchaseService.java
package com.shops.service;

import com.shops.entity.Purchase;
import com.shops.repository.PurchaseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseService {
    private final PurchaseRepository purchaseRepository;

    public PurchaseService(PurchaseRepository purchaseRepository) {
        this.purchaseRepository = purchaseRepository;
    }
    
    public List<Purchase> findAll() {
        return purchaseRepository.findAll();
    }
    
    public Purchase save(Purchase purchase) {
        return purchaseRepository.save(purchase);
    }
}