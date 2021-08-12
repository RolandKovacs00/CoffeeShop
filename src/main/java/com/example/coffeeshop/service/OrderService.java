package com.example.coffeeshop.service;

import com.example.coffeeshop.model.Orders;
import com.example.coffeeshop.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Orders> orders() {
        return orderRepository.findAll();
    }

    public Orders addNewProduct(Orders order) {
        return orderRepository.save(order);
    }

    public Optional<Orders> findProduct(Long id) {
        return orderRepository.findById(id);
    }

    public void deleteProduct(Long id) {
        orderRepository.deleteById(id);
    }
}