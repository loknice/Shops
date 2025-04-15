// src/main/java/com/shops/controller/PurchaseController.java
package com.shops.controller;

import com.shops.entity.*;
import com.shops.service.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@RequestMapping("/purchases")
public class PurchaseController {
    private final PurchaseService purchaseService;
    private final CustomerService customerService;
    private final ShopService shopService;
    private final ProductService productService;

    public PurchaseController(PurchaseService purchaseService,
                            CustomerService customerService,
                            ShopService shopService,
                            ProductService productService) {
        this.purchaseService = purchaseService;
        this.customerService = customerService;
        this.shopService = shopService;
        this.productService = productService;
    }

    @GetMapping("/list")
    public String listPurchases(Model model) {
        model.addAttribute("purchases", purchaseService.findAll());
        return "purchases/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("customers", customerService.findAll());
        model.addAttribute("shops", shopService.findAll());
        model.addAttribute("products", productService.findAll());
        model.addAttribute("purchase", new Purchase());
        return "purchases/add-form";
    }

    @PostMapping("/add")
    public String addPurchase(@ModelAttribute Purchase purchase,
                            @RequestParam("purchaseDate") String purchaseDateStr) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
        purchase.setPurchaseDate(LocalDate.parse(purchaseDateStr, formatter));
        purchaseService.save(purchase);
        return "redirect:/purchases/list";
    }
}