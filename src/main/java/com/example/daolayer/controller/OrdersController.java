package com.example.daolayer.controller;

import com.example.daolayer.model.Order;
import com.example.daolayer.repository.OrdersRepositoryImpl;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OrdersController {
    private final OrdersRepositoryImpl ordersRepository;

    public OrdersController(OrdersRepositoryImpl ordersRepository) {
        this.ordersRepository = ordersRepository;
    }

    //http://localhost:8080/products/fetch-product?name=Alexey
    @GetMapping(value = "/products/fetch-product", produces = "application/json")
    public List<Order> getProductsByCustomerName(@RequestParam String name) {
        return ordersRepository.findProductsByCustomerName(name);
    }
}
