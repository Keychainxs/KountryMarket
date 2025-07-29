package com.kountrymarket.conveniencestore.model;

import org.springframework.data.annotation.Id;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class User {
    
    @GeneratedValue(strategy= GenerationType.IDENTITY)
   
    @Id
    private Long id;

    private String password;
    private String role;
    private String username;
    
   public User() {}

    public User(String username, Long id, String password, String role) {
        this.username = username;
        this.id = id;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
   
}
