package com.sagar.reactdigitaldealsbackend.service;

import com.sagar.reactdigitaldealsbackend.model.Cartitemdummy;

import java.util.List;

public interface CartitemdummyService {
    void addCartitemdummy(Cartitemdummy cartitemdummy);
    void updateCartitemdummy(Cartitemdummy cartitemdummy);
    void deleteCartitemdummy(int id);
    Cartitemdummy getCartitemdummyById(int id);
    List<Cartitemdummy> getAllCartitemdummies();
}
