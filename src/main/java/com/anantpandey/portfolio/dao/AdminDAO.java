package com.anantpandey.portfolio.dao;

import com.anantpandey.portfolio.db.DatabaseConnection;
import com.anantpandey.portfolio.model.Admin;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Handles all database operations for Admin objects.
 */
public class AdminDAO {

    /**
     * Retrieves an admin by username from the database.
     */
    public Admin getAdminByUsername(String username) {
        Admin admin = null;
        String sql = "SELECT * FROM admins WHERE username = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, username);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    admin = new Admin();
                    admin.setAdminId(rs.getInt("admin_id"));
                    admin.setUsername(rs.getString("username"));
                    admin.setPasswordHash(rs.getString("password_hash"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return admin;
    }
}