package com.example.daolayer.repository;

import com.example.daolayer.model.Order;

import java.util.List;

public interface OrdersRepository {
     List<Order> findProductsByCustomerName (String customerName);
}
