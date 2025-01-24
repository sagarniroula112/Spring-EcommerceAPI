package com.sagar.reactdigitaldealsbackend.service;

import com.sagar.reactdigitaldealsbackend.model.Cart;

import java.util.List;

public interface CartService {
    void addCart(Cart cart);
    void updateCart(Cart cart);
    void deleteCart(int id);
    Cart getCartById(int id);
    List<Cart> getAllCarts();
}
