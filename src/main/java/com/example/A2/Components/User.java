package com.example.A2.Components;
public class User implements java.io.Serializable {

    private String username;
    private String email;
    private String password = "password";
    
    public User(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
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

    public String getPassword() { //Very secure...
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
}