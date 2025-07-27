package com.kountrymarket.conveniencestore.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.kountrymarket.conveniencestore.dto.AdminDTO;
import com.kountrymarket.conveniencestore.dto.LoginDTO;
import com.kountrymarket.conveniencestore.model.User;
import com.kountrymarket.conveniencestore.repsitory.UserRepository;

public class AdminService {
   
    
    @Autowired
    private UserRepository userRepo;

    @Autowired

    private PasswordEncoder passwordEncoder;


    public void registerAdmin(AdminDTO adminDTO) {

        if(userRepo.findByUsername(adminDTO.getUsername()).isPresent()) {
            throw new RuntimeException("Admin already exists");
            
        }


        User user = new User();
        user.setUserName(adminDTO.getUsername());
        user.setPassword(passwordEncoder.encode(adminDTO.getPassword()));

        user.setRole("ADMIN");
        userRepo.save(user);
        
    }


    public User loginAdmin(LoginDTO loginDTO) {
        
      Optional<User> optionalAdmin = userRepo.findByUsername(loginDTO.getUsername());

      if(optionalAdmin.isEmpty()) {
        throw new IllegalArgumentException("Invlaid username");
      }

      User admin = optionalAdmin.get();

      if(!admin.getRole().equals("ADMIN")) {
        throw new IllegalArgumentException("Invalid Username or Password");
      }


      return admin;
      
    }

    public void logoutAdmin() {}



}
