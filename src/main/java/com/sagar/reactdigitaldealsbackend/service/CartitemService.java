package com.sagar.reactdigitaldealsbackend.service;

import com.sagar.reactdigitaldealsbackend.model.Cart;
import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import com.sagar.reactdigitaldealsbackend.model.User;

import java.util.List;

public interface CartitemService {
    void addCartitem(Cartitem cartitem);
    void updateCartitem(Cartitem cartitem);
    void deleteCartitem(int id);
    Cartitem getCartitemById(int id);
    List<Cartitem> getCartitems();
    List<Cartitem> getAllCartitemsByCart(Cart cart);
}
