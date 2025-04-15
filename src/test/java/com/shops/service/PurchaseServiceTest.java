// src/test/java/com/shops/service/PurchaseServiceTest.java
package com.shops.service;

import com.shops.entity.Purchase;
import com.shops.repository.PurchaseRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

/**
 * Тести для PurchaseService
 */
@ExtendWith(MockitoExtension.class)
public class PurchaseServiceTest {

    @Mock
    private PurchaseRepository purchaseRepository;

    @InjectMocks
    private PurchaseService purchaseService;

    /**
     * Тест отримання списку покупок
     */
    @Test
    void findAll_ShouldReturnAllPurchases() {
        // Підготовка тестових даних
        Purchase purchase = new Purchase();
        when(purchaseRepository.findAll()).thenReturn(Collections.singletonList(purchase));

        // Виконання методу
        List<Purchase> result = purchaseService.findAll();

        // Перевірка результатів
        assertThat(result).hasSize(1);
        verify(purchaseRepository).findAll();
    }

    /**
     * Тест збереження покупки
     */
    @Test
    void save_ShouldReturnSavedPurchase() {
        Purchase purchase = new Purchase();
        when(purchaseRepository.save(any(Purchase.class))).thenReturn(purchase);

        Purchase result = purchaseService.save(purchase);

        assertThat(result).isNotNull();
        verify(purchaseRepository).save(purchase);
    }
}