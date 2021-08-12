package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.Address;
import com.example.coffeeshop.model.Customer;
import com.example.coffeeshop.repository.CustomerRepository;
import com.example.coffeeshop.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class CustomerController {
    private final CustomerRepository customerRepository;
    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerRepository customerRepository, CustomerService customerService) {
        this.customerRepository = customerRepository;
        this.customerService = customerService;
    }

    @GetMapping("/allCustomers")
    public ResponseEntity<List<Customer>> customer() {
        List<Customer> customers = customerService.customers();
        return new ResponseEntity<List<Customer>>(customers, HttpStatus.OK);
    }

    @PostMapping("/newCustomer")
    public ResponseEntity<Customer> addNewProduct(@RequestBody Customer cus) {
        Customer customer = null;
        try {
            customer = customerService.addNewProduct(cus);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ResponseEntity<Customer>(customer, HttpStatus.OK);
    }

    @DeleteMapping("deleteCustomer/{id}")
    public void delete(@PathVariable Long id) {
        customerService.deleteProduct(id);
    }

    @PutMapping("updateCustomer/{id}")
    public ResponseEntity<Customer> update(@PathVariable Long id, @RequestBody Customer customers) {
        Optional<Customer> cus = customerRepository.findById(id);
        if (cus.isPresent()) {
            Customer customer = cus.get();
            customer.setName(customers.getName());
            customer.setCash(customers.getCash());
            customer.setCard_number(customers.getCard_number());
            customer.setCVV(customers.getCVV());
            customer.setDate(customers.getDate());
            return new ResponseEntity<>(customerService.addNewProduct(customer), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("customer/{id}")
    public Optional<Customer> getProductById(@PathVariable Long id) {
        return customerService.findProduct(id);
    }
}
