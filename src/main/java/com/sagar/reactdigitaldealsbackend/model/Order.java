package com.sagar.reactdigitaldealsbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double totalAmount;
    private LocalDateTime orderDate;
    private String deliveryStatus;

    // This will connect to "User", "Cartitem", "Cartitemdummy" and "Product".
}
