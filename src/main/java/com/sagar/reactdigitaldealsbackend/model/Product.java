package com.sagar.reactdigitaldealsbackend.model;

import jakarta.persistence.*;

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String description;
    private double price;
    private String image;
    private double discount;
    private double discountedPrice;
    private int stockQuantity;
    private double rating;

    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="category_id")
    private Category category;

    // This will connect to "Category".
}
