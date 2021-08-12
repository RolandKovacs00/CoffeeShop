package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Coffee;
import com.example.coffeeshop.repository.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoffeeService {
    private final CoffeeRepository coffeeRepository;

    @Autowired
    public CoffeeService(CoffeeRepository coffeeRepository) {
        this.coffeeRepository = coffeeRepository;
    }

    public List<Coffee> coffees() {
        return coffeeRepository.findAll();
    }

    public Coffee addNewProduct(Coffee coffee) {
        return coffeeRepository.save(coffee);
    }

    public Optional<Coffee> findProduct(Long id) {
        return coffeeRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        coffeeRepository.deleteById(id);
    }
}
