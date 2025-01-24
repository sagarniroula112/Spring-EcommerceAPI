package com.sagar.reactdigitaldealsbackend.service;

import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import com.sagar.reactdigitaldealsbackend.model.User;

import java.util.List;

public interface CartitemService {
    void addCartitem(Cartitem cartitem);
    void updateCartitem(Cartitem cartitem);
    void deleteCartitem(int id);
    Cartitem getCartitem(int id);
    List<Cartitem> getCartitems();
    List<Cartitem> getAllCartitemsByUser(User user);
}
