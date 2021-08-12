package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Customer;
import com.example.coffeeshop.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService {
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public List<Customer> customers() {
        return customerRepository.findAll();
    }

    public Customer addNewProduct(Customer customer) {
        return customerRepository.save(customer);
    }

    public Optional<Customer> findProduct(Long id) {
        return customerRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        customerRepository.deleteById(id);
    }
}
