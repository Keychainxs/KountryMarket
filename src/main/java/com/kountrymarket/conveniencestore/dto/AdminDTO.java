package com.kountrymarket.conveniencestore.dto;

import java.util.List;     

public class AdminDTO {
    
    private Long adminID;
    private String username;
    
    private List<String> roles;    
    private String email;

    private String password; 

    public AdminDTO() {}

    public AdminDTO(String username, String email, String password, Long adminID, List<String> roles) {
            if(roles == null) {
                throw new IllegalArgumentException("List of role objects is null");
            }

            this.roles = roles;
            this.username = username;
            this.email = email;
            this.password = password;
            this.adminID = adminID;
    }

    public Long getAdminID() {
    
        return adminID;
    }

    public void setAdminID(Long adminID) {
        if (adminID == null) {
           throw new IllegalArgumentException("admin ID Found to be bull");
        }
        
        this.adminID = adminID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if(username == null || username.isEmpty()) {
            throw new IllegalArgumentException("Email length is less than zero");
        }
        
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        if(email == null || email.isEmpty()) {
            throw new IllegalArgumentException("Email length is less than zero");
        }
        
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if(password.length() < 0) {
            throw new IllegalArgumentException("Password length is less than zero");
        }   
        this.password = password;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }
}
