package com.sagar.reactdigitaldealsbackend.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name="order_table")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String deliveryStatus;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToMany
    @JoinTable(
            name="order_cartitem",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name = "cartitem_id")
    )
    private List<Cartitem> cartitems;

    @ManyToMany
    @JoinTable(
            name="order_cartitemdummies",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name = "cartitemdummy_id")
    )
    private List<Cartitemdummy> cartitemdummys;

    // This will connect to "User", "Cartitem", "Cartitemdummy" and "Product".
}
