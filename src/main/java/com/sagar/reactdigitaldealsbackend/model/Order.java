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
            name="order_cartitemdummies",
            joinColumns = @JoinColumn(name="order_id"),
            inverseJoinColumns = @JoinColumn(name = "cartitemdummy_id")
    )
    private List<Cartitemdummy> cartitemdummys;

    // This will connect to "User", "Cartitem", "Cartitemdummy" and "Product".

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

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Cartitemdummy> getCartitemdummys() {
        return cartitemdummys;
    }

    public void setCartitemdummys(List<Cartitemdummy> cartitemdummys) {
        this.cartitemdummys = cartitemdummys;
    }
}
