package com.example.A2.Components;

public class User implements java.io.Serializable {
    
    private String username;
    private String email;
    
    public User() {
    }

    public String getName() {
        return username;
    }
    
    public void setName(String newName) {
        this.username = newName;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
}