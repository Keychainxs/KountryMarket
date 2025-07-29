package com.kountrymarket.conveniencestore.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
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
import com.kountrymarket.conveniencestore.model.User;
import com.kountrymarket.conveniencestore.security.JwtUtil;
import com.kountrymarket.conveniencestore.service.AdminService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



@RestController

@RequestMapping("/api/admin")


public class AdminController {
   
    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AdminService adminService;

   @PostMapping("/register")
   public ResponseEntity<?> registerAdmin(@RequestBody AdminDTO adminDTO) {
    try {
        adminService.registerAdmin(adminDTO);
        return ResponseEntity.ok("User Registered");
    } catch (Exception e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginDTO loginDTO) {
        User admin = adminService.loginAdmin(loginDTO);
        String jwt = jwtUtil.generateToken(admin.getUsername(), admin.getRole());
        return ResponseEntity.ok(Collections.singletonMap("token", jwt));
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
    
   
    

  
}
