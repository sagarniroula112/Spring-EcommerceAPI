package com.sagar.reactdigitaldealsbackend.serviceimpl;

import com.sagar.reactdigitaldealsbackend.model.Cartitemdummy;
import com.sagar.reactdigitaldealsbackend.repository.CartitemdummyRepo;
import com.sagar.reactdigitaldealsbackend.service.CartitemdummyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartitemdummyServiceImpl implements CartitemdummyService {
    @Autowired
    private CartitemdummyRepo cartitemdummyRepo;

    @Override
    public void addCartitemdummy(Cartitemdummy cartitemdummy) {
        cartitemdummyRepo.save(cartitemdummy);
    }

    @Override
    public void updateCartitemdummy(Cartitemdummy cartitemdummy) {
        cartitemdummyRepo.save(cartitemdummy);
    }

    @Override
    public void deleteCartitemdummy(int id) {
        cartitemdummyRepo.deleteById(id);
    }

    @Override
    public Cartitemdummy getCartitemdummyById(int id) {
        return cartitemdummyRepo.findById(id).get();
    }

    @Override
    public List<Cartitemdummy> getAllCartitemdummies() {
        return cartitemdummyRepo.findAll();
    }
}
