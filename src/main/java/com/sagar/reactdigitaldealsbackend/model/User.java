package com.sagar.reactdigitaldealsbackend.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String role;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private String phone;
    private String address;
    private String username;

    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name="cart_id")
    private Cart cart;
    // Cascade: If a user is saved/updated/deleted/reloaded/detached, the Cart will also be saved/
    // updated/deleted/reloaded/detached.
    // Cascade makes sure that the Cart is always in sync with the User.
    // OrphanRemoval: If a user is deleted, the cart is deleted too.

    // This will connect to a "Cart" and a cart must automatically be created when a user is registered.
}
