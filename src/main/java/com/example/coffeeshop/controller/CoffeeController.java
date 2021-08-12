package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.Coffee;
import com.example.coffeeshop.repository.CoffeeRepository;
import com.example.coffeeshop.service.CoffeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class CoffeeController {
    private final CoffeeRepository coffeeRepository;
    private final CoffeeService coffeeService;

    @Autowired
    public CoffeeController(CoffeeRepository coffeeRepository, CoffeeService coffeeService) {
        this.coffeeRepository = coffeeRepository;
        this.coffeeService = coffeeService;
    }

    @GetMapping("/AllCoffees")
    public ResponseEntity<List<Coffee>> coffee() {
        List<Coffee> coffees = coffeeService.coffees();
        return new ResponseEntity<List<Coffee>>(coffees, HttpStatus.OK);
    }

    @DeleteMapping("deleteCoffee/{id}")
    public void delete(@PathVariable Long id) {
        coffeeService.deleteProduct(id);
    }

    @GetMapping("coffee/{id}")
    public Optional<Coffee> getProductById(@PathVariable Long id) {
        return coffeeService.findProduct(id);
    }
}
