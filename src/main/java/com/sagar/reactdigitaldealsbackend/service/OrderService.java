package com.sagar.reactdigitaldealsbackend.service;

import com.sagar.reactdigitaldealsbackend.model.Order;

import java.util.List;

public interface OrderService {
    void addOrder(Order order);
    void updateOrder(Order order);
    void deleteOrder(int id);
    Order getOrderById(int id);
    List<Order> getAllOrders();
}
