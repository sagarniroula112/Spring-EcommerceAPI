package com.sagar.reactdigitaldealsbackend.repository;

import com.sagar.reactdigitaldealsbackend.model.Cartitem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartitemRepo extends JpaRepository<Cartitem, Integer> {
}
