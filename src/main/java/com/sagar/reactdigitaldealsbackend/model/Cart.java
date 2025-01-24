package com.sagar.reactdigitaldealsbackend.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalAmount;
    private boolean checkedOut;

    @OneToMany
    private List<Cartitem> cartItems;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private User user;

    // This will connect to "Cartitem" and a "User".

    public Cart() {
        this.cartItems = null;
        this.totalAmount = 0;
        this.checkedOut = false;
    }
}
