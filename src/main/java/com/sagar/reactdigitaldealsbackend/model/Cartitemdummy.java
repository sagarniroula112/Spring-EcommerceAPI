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
    private int orderId;

    @ManyToOne
    @JoinColumn(name="product_id")
    private Product product;
    // Many cartitems can be linked to a single product.

//    @ManyToOne
//    @JoinColumn(name="order_id")
//    private Order order;
////     Many cartitems can be linked to a single order.

//    @ManyToOne
//    @JoinColumn(name="user_id")
//    private User user;
    // Many cartitems can be linked to a user.

    @ManyToOne
    @JoinColumn(name="cart_id")
    private Cart cart;
    // Many cartitems can be linked to a cart.

    // This will connect to product, order, user and a cart.

//    public Order getOrder() {
//        return order;
//    }
//
//    public void setOrder(Order order) {
//        this.order = order;
//    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

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

    public LocalDateTime getDummyCreatedDateTime() {
        return dummyCreatedDateTime;
    }

    public void setDummyCreatedDateTime(LocalDateTime dummyCreatedDateTime) {
        this.dummyCreatedDateTime = dummyCreatedDateTime;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }
}
