package com.sagar.reactdigitaldealsbackend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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
}
