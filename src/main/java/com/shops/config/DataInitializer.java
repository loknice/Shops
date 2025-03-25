// src/main/java/com/shops/config/DataInitializer.java
package com.shops.config;

import com.shops.entity.*;
import com.shops.service.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;

@Component
public class DataInitializer implements CommandLineRunner {
    private final CustomerService customerService;
    private final ShopService shopService;
    private final ProductService productService;
    private final PurchaseService purchaseService;

    public DataInitializer(CustomerService customerService,
                         ShopService shopService,
                         ProductService productService,
                         PurchaseService purchaseService) {
        this.customerService = customerService;
        this.shopService = shopService;
        this.productService = productService;
        this.purchaseService = purchaseService;
    }

    @Override
    @Transactional
    public void run(String... args) {
        // Створення тестових даних
        Customer customer = new Customer();
        customer.setFullName("Іваненко Іван Іванович");
        customer.setBonusCardNumber("1234567890");
        customerService.save(customer);

        Shop shop = new Shop();
        shop.setAddress("вул. Хрещатик, 24");
        shop.setCity("Київ");
        shopService.save(shop);

        Product product = new Product();
        product.setName("Молоко");
        product.setProductGroup("Молочні продукти");
        product.setDepartment("Молочний відділ");
        product.setExpiryDate("14.10.2024");
        productService.save(product);

        Purchase purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setShop(shop);
        purchase.setProduct(product);
        purchase.setPaymentMethod("Готівка");
        purchase.setPurchaseDate(LocalDate.of(2024, 9, 12));
        purchase.setQuantity(2);
        purchase.setAmount(120);
        purchase.setBonusEarned(12);
        purchase.setDiscount(0);
        purchaseService.save(purchase);
    }
}