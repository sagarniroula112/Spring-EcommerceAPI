package com.sagar.reactdigitaldealsbackend.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Cartitemdummy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int purchaseQuantity;
    private double purchaseAmount;
    private LocalDateTime dummyCreatedDateTime;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    // Many cartitems can be linked to a single product.

    @ManyToOne
    @JoinColumn(name="order_id")
    private Order order;
    // Many cartitems can be linked to a single product.

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;
    // Many cartitems can be linked to a user.

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;
    // Many cartitems can be linked to a cart.

    // This will connect to product, order, user and a cart.
}
