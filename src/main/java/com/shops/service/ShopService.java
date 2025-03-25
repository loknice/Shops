// src/main/java/com/shops/service/ShopService.java
package com.shops.service;

import com.shops.entity.Shop;
import com.shops.repository.ShopRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShopService {
    private final ShopRepository shopRepository;

    public ShopService(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }
    
    public List<Shop> findAll() {
        return shopRepository.findAll();
    }
    
    public Shop save(Shop shop) {
        return shopRepository.save(shop);
    }
}