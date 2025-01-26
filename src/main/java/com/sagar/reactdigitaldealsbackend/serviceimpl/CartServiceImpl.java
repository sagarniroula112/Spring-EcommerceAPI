package com.sagar.reactdigitaldealsbackend.serviceimpl;

import com.sagar.reactdigitaldealsbackend.model.Cart;
import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import com.sagar.reactdigitaldealsbackend.model.User;
import com.sagar.reactdigitaldealsbackend.repository.CartRepo;
import com.sagar.reactdigitaldealsbackend.service.CartService;
import com.sagar.reactdigitaldealsbackend.service.CartitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartServiceImpl implements CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartitemService cartitemService;

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

    @Override
    public Cart getCartByUser(User user) {
        return cartRepo.findByUser(user);
    }

    @Override
    public Double calculateCartTotal(Cart cart) {
        List<Cartitem> cartitems = cartitemService.getAllCartitemsByCart(cart);
        System.out.println("Cart Items: " + cartitems);

        double total = 0.0;
        for (Cartitem cartitem : cartitems) {
            System.out.println("Purchase Amount for item ID " + cartitem.getId() + ": " + cartitem.getPurchaseAmount());
            total += cartitem.getPurchaseAmount();
        }

        System.out.println("Total: " + total);
        return total;
    }

}
