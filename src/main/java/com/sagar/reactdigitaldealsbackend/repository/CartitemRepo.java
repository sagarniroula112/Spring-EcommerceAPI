package com.sagar.reactdigitaldealsbackend.repository;

import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import com.sagar.reactdigitaldealsbackend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CartitemRepo extends JpaRepository<Cartitem, Integer> {
    List<Cartitem> findAllByUser(User user);
}
