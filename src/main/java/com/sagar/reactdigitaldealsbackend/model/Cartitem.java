package com.sagar.reactdigitaldealsbackend.model;

import jakarta.persistence.*;

@Entity
public class Cartitem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int purchaseQuantity;
    private double purchaseAmount;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    // Many cartitems can be linked to a single product.

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    // Many cartitems can be linked to a user.

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;
    // Many cartitems can be linked to a cart.

    // This will connect to product, "User" and a cart.
}
