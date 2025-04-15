// src/main/java/com/shops/service/CustomerService.java
package com.shops.service;

import com.shops.entity.Customer;
import com.shops.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }
    
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }
    
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}