package com.example.A2.Components;

import java.util.UUID;

public class User implements java.io.Serializable {

    private String username;
    private String email;
    private String password;
    private UUID id;
    
    public User(String username, String email, String password) {
        this.id = UUID.randomUUID();
        this.username = username;
        this.email = email;
        this.password = password;
    }

    public UUID getId() {
        return id;
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
    
    public void setEmail(String newEmail) {
        this.email = newEmail;
    }

    public String getPassword() { //Very secure...
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}