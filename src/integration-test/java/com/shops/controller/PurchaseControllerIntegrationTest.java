// src/integration-test/java/com/shops/controller/PurchaseControllerIntegrationTest.java
package com.shops.controller;

import com.shops.MainApp;
import com.shops.entity.*;
import com.shops.service.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest(
    classes = MainApp.class,
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
@ActiveProfiles("test")
@TestPropertySource(locations = "classpath:application-test.properties")
@Transactional
public class PurchaseControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;
    
    @Autowired
    private CustomerService customerService;
    
    @Autowired
    private ShopService shopService;
    
    @Autowired
    private ProductService productService;
    
    @Autowired
    private PurchaseService purchaseService;
    
    private Customer customer;
    private Shop shop;
    private Product product;
    private Purchase purchase;
    
    @BeforeEach
    void setUp() {
        // Створення тестових даних
        customer = new Customer();
        customer.setFullName("Іваненко Іван Іванович");
        customer.setBonusCardNumber("1234567890");
        customer = customerService.save(customer);
        
        shop = new Shop();
        shop.setAddress("вул. Хрещатик, 24");
        shop.setCity("Київ");
        shop = shopService.save(shop);
        
        product = new Product();
        product.setName("Молоко");
        product.setProductGroup("Молочні продукти");
        product.setDepartment("Молочний відділ");
        product.setExpiryDate("14.10.2024");
        product = productService.save(product);
        
        // Створення тестової покупки
        purchase = new Purchase();
        purchase.setCustomer(customer);
        purchase.setShop(shop);
        purchase.setProduct(product);
        purchase.setPaymentMethod("Готівка");
        purchase.setQuantity(2);
        purchase.setAmount(120);
        purchase.setBonusEarned(12);
        purchase.setDiscount(0);
        purchaseService.save(purchase);
    }
    
    @Test
    void listPurchases_ShouldDisplayPurchasesPage() throws Exception {
        mockMvc.perform(get("/purchases/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("purchases/list"))
                .andExpect(model().attributeExists("purchases"));
    }
    
    @Test
    void showAddForm_ShouldDisplayAddForm() throws Exception {
        mockMvc.perform(get("/purchases/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("purchases/add-form"))
                .andExpect(model().attributeExists("customers"))
                .andExpect(model().attributeExists("shops"))
                .andExpect(model().attributeExists("products"))
                .andExpect(model().attributeExists("purchase"));
    }
}