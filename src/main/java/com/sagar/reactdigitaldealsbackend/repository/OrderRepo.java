package com.sagar.reactdigitaldealsbackend.repository;

import com.sagar.reactdigitaldealsbackend.model.Order;
import com.sagar.reactdigitaldealsbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepo extends JpaRepository<Order, Integer> {
    List<Order> findAllByUser(User user);
}
