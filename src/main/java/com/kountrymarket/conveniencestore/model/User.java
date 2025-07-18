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

    public String getUserName() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }


    public Long getUserIDLong() {
        return id;
    }

    public Long setID(Long id) {
        return this.id = id;
    }


    public String getRole() {
        return role;
    }    

    public String setRole(String role) {
        return this.role = role;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    
}
