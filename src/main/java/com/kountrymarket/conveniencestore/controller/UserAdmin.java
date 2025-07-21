package com.kountrymarket.conveniencestore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kountrymarket.conveniencestore.dto.AdminDTO;
import com.kountrymarket.conveniencestore.dto.LoginDTO;



@RestController

@RequestMapping("/api/admin")


public class UserAdmin {
    
    @PostMapping("/api/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminDTO adminDTO, boolean success) {
        if(success) {
            return ResponseEntity.ok("User Registered");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Registration");
    
    }

    @PostMapping("/api/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginDTO loginDTO, boolean success) {
        //TODO: process POST request
        if(success) {
            return ResponseEntity.ok("User Successfully Logged In.");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Loggin Credentials, Try Again");
        

    }


    @PostMapping("/logout")
    public String logoutAdmin(@RequestBody String entity) {
        //TODO: process POST request
            
        return entity;
    }
    
    
    

  
}
