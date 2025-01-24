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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isCheckedOut() {
        return checkedOut;
    }

    public void setCheckedOut(boolean checkedOut) {
        this.checkedOut = checkedOut;
    }

    public List<Cartitem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<Cartitem> cartItems) {
        this.cartItems = cartItems;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
