package com.kountrymarket.conveniencestore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kountrymarket.conveniencestore.dto.AdminDTO;
import com.kountrymarket.conveniencestore.dto.LoginDTO;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@RestController

@RequestMapping("/api/admin")


public class AdminController {
    
    @PostMapping("/api/register")
    public ResponseEntity<?> registerAdmin(@RequestBody AdminDTO adminDTO, boolean success) {
        if(success) {
            return ResponseEntity.ok("User Registered");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Registration");
    
    }

    @PostMapping("/api/admin/login")
    public ResponseEntity<?> loginAdmin(@RequestBody LoginDTO loginDTO, boolean success) {
       
        if(success) {
            return ResponseEntity.ok("User Successfully Logged In.");
        }

        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Loggin Credentials, Try Again");
        

    }
    
    @PostMapping("/logout")
        public ResponseEntity<?> logoutAdmin(       
           
            Authentication authentication,
            HttpServletRequest request,
            HttpServletResponse response) {
            SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler(); 
            logoutHandler.logout(request, response, authentication);
        return ResponseEntity.ok("Logged out");
}
    
    
    
    /*
     * 
     * 
     * 
     * 
     *    SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();

    @PostMapping("/logout")
    public String logoutAdmin(Authentication authentication, HttpServletRequest request, HttpServletResponse response) {
        this.logoutHandler.logout(request, response, authentication);
         
            return "redirect:/home";

    }
     */
  
}
