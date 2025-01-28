package com.sagar.reactdigitaldealsbackend.serviceimpl;

import com.sagar.reactdigitaldealsbackend.model.Order;
import com.sagar.reactdigitaldealsbackend.model.User;
import com.sagar.reactdigitaldealsbackend.repository.OrderRepo;
import com.sagar.reactdigitaldealsbackend.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderRepo orderRepo;

    @Override
    public void addOrder(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void updateOrder(Order order) {
        orderRepo.save(order);
    }

    @Override
    public void deleteOrder(int id) {
        orderRepo.deleteById(id);
    }

    @Override
    public Order getOrderById(int id) {
        return orderRepo.findById(id).get();
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepo.findAll();
    }

    @Override
    public List<Order> getAllOrdersByUser(User user) {
        return orderRepo.findAllByUser(user);
    }
}
