package com.bb.food.models;

public class UserManagerFood {
    String username,email, password;
    int role = 0;

    public UserManagerFood(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.role = 0;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }
}
