package com.sagar.reactdigitaldealsbackend.serviceimpl;

import com.sagar.reactdigitaldealsbackend.model.Cart;
import com.sagar.reactdigitaldealsbackend.repository.CartRepo;
import com.sagar.reactdigitaldealsbackend.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepo cartRepo;

    @Override
    public void addCart(Cart cart) {
        cartRepo.save(cart);
    }

    @Override
    public void updateCart(Cart cart) {
        cartRepo.save(cart);
    }

    @Override
    public void deleteCart(int id) {
        cartRepo.deleteById(id);
    }

    @Override
    public Cart getCartById(int id) {
        return cartRepo.findById(id).get();
    }

    @Override
    public List<Cart> getAllCarts() {
        return cartRepo.findAll();
    }
}
