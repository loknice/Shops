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

@SpringBootTest(classes = MainApp.class)
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
    
    @BeforeEach
    void setUp() {
        customer = new Customer();
        customer.setFullName("Іваненко Іван Іванович");
        customer.setBonusCardNumber("1234567890");
        customerService.save(customer);
        
        shop = new Shop();
        shop.setAddress("вул. Хрещатик, 24");
        shop.setCity("Київ");
        shopService.save(shop);
        
        product = new Product();
        product.setName("Молоко");
        product.setProductGroup("Молочні продукти");
        product.setDepartment("Молочний відділ");
        product.setExpiryDate("14.10.2024");
        productService.save(product);
    }
    
    @Test
    void listPurchases_ShouldDisplayPurchasesPage() throws Exception {
        mockMvc.perform(get("/purchases/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("purchases/list"))
                .andExpect(model().attributeExists("purchases"));
    }
    
    // Other test methods
}