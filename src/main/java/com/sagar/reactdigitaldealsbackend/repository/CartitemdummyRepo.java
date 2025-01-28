package com.sagar.reactdigitaldealsbackend.repository;

import com.sagar.reactdigitaldealsbackend.model.Cart;
import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import com.sagar.reactdigitaldealsbackend.model.Cartitemdummy;
import com.sagar.reactdigitaldealsbackend.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartitemdummyRepo extends JpaRepository<Cartitemdummy, Integer> {
    List<Cartitemdummy> findAllByCart(Cart cart);
    List<Cartitemdummy> findAllByCartAndOrderId(Cart cart, int orderId);
}
