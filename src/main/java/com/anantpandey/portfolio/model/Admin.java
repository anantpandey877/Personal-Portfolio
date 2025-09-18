package com.anantpandey.portfolio.model;

/**
 * POJO representing a user from the 'admins' table.
 */
public class Admin {
    private int adminId;
    private String username;
    private String passwordHash;

    public Admin() {
    }

    // Getters and Setters
    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}