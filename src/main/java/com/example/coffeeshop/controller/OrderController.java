package com.example.coffeeshop.controller;

import com.example.coffeeshop.model.Address;
import com.example.coffeeshop.model.Orders;
import com.example.coffeeshop.repository.OrderRepository;
import com.example.coffeeshop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class OrderController {
    private final OrderRepository orderRepository;
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderRepository orderRepository, OrderService orderService) {
        this.orderRepository = orderRepository;
        this.orderService = orderService;
    }

    @GetMapping("/allOrders")
    public ResponseEntity<List<Orders>> order() {
        List<Orders> orders = orderService.orders();
        return new ResponseEntity<List<Orders>>(orders, HttpStatus.OK);
    }

    @PostMapping("/newOrder")
    public ResponseEntity<Orders> addNewProduct(@RequestBody Orders ord) {
        Orders order = null;
        try {
            order = orderService.addNewProduct(ord);
        } catch (Exception e) {
            e.getMessage();
        }
        return new ResponseEntity<Orders>(order, HttpStatus.OK);
    }

    @DeleteMapping("deleteOrder/{id}")
    public void delete(@PathVariable Long id) {
        orderService.deleteProduct(id);
    }

    @PutMapping("updateOrder/{id}")
    public ResponseEntity<Orders> update(@PathVariable Long id, @RequestBody Orders orders) {
        Optional<Orders> ord = orderRepository.findById(id);
        if (ord.isPresent()) {
            Orders order = ord.get();
            order.setAmount(orders.getAmount());
            return new ResponseEntity<>(orderService.addNewProduct(order), HttpStatus.OK);
        }
        else return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("order/{id}")
    public Optional<Orders> getProductById(@PathVariable Long id) {
        return orderService.findProduct(id);
    }
}
