package com.sagar.reactdigitaldealsbackend.service;

import com.sagar.reactdigitaldealsbackend.model.Cart;
import com.sagar.reactdigitaldealsbackend.model.Cartitemdummy;
import com.sagar.reactdigitaldealsbackend.model.Order;

import java.util.List;

public interface CartitemdummyService {
    void addCartitemdummy(Cartitemdummy cartitemdummy);
    void updateCartitemdummy(Cartitemdummy cartitemdummy);
    void deleteCartitemdummy(int id);
    Cartitemdummy getCartitemdummyById(int id);
    List<Cartitemdummy> getAllCartitemdummies();
    List<Cartitemdummy> getAllCartitemdummiesByCart(Cart cart);
    List<Cartitemdummy> getAllCartitemdummiesByCartAndOrderId(Cart cart, int orderId);
}
