package com.kountrymarket.conveniencestore.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController

@RequestMapping("/api/admin")
public class UserAdmin {
    
    @PostMapping("/register/admin")
    public String registerAdmin(@RequestBody String entity) {
        //TODO: process POST request
        
        return entity;
    }
    
   
}
