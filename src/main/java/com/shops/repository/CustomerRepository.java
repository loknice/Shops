// src/main/java/com/shops/repository/CustomerRepository.java
package com.shops.repository;

import com.shops.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
}