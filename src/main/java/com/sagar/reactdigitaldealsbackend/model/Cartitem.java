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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPurchaseQuantity() {
        return purchaseQuantity;
    }

    public void setPurchaseQuantity(int purchaseQuantity) {
        this.purchaseQuantity = purchaseQuantity;
    }

    public double getPurchaseAmount() {
        return purchaseAmount;
    }

    public void setPurchaseAmount(double purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
