package com.sagar.reactdigitaldealsbackend.serviceimpl;

import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import com.sagar.reactdigitaldealsbackend.model.User;
import com.sagar.reactdigitaldealsbackend.repository.CartitemRepo;
import com.sagar.reactdigitaldealsbackend.service.CartitemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartitemServiceImpl  implements CartitemService {

    @Autowired
    private CartitemRepo cartitemRepo;

    @Override
    public void addCartitem(Cartitem cartitem) {
        cartitemRepo.save(cartitem);
    }

    @Override
    public void updateCartitem(Cartitem cartitem) {
        cartitemRepo.save(cartitem);
    }

    @Override
    public void deleteCartitem(int id) {
        cartitemRepo.deleteById(id);
    }

    @Override
    public Cartitem getCartitem(int id) {
        return cartitemRepo.findById(id).get();
    }

    @Override
    public List<Cartitem> getCartitems() {
        return cartitemRepo.findAll();
    }

    @Override
    public List<Cartitem> getAllCartitemsByUser(User user) {
        return cartitemRepo.findAllByUser(user);
    }
}
