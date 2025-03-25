package com.shops.entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "purchases")
public class Purchase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @ManyToOne
    private Customer customer;
    
    @ManyToOne
    private Shop shop;
    
    @ManyToOne
    private Product product;
    
    private String paymentMethod;
    private LocalDate purchaseDate;
    private double quantity;
    private double amount;
    private double bonusEarned;
    private double discount;
    
    // Геттеры и сеттеры для всех полей
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // ... остальные геттеры и сеттеры
    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDate purchaseDate) {
        this.purchaseDate = purchaseDate;
    }
    // и так для всех полей
}