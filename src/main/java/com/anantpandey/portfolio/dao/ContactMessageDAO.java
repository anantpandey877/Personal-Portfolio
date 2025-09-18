package com.anantpandey.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anantpandey.portfolio.db.DatabaseConnection;
import com.anantpandey.portfolio.model.ContactMessage;

/**
 * Handles database operations for ContactMessage objects.
 */
public class ContactMessageDAO {
    
    /**
     * Saves a new contact message to the database.
     */
    public void saveMessage(ContactMessage message) {
        String sql = "INSERT INTO contact_messages (sender_name, sender_email, message_text) VALUES (?, ?, ?)";
        
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setString(1, message.getSenderName());
            pstmt.setString(2, message.getSenderEmail());
            pstmt.setString(3, message.getMessageText());
            
            pstmt.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Retrieves all contact messages from the database, ordered by newest first.
     * @return A list of ContactMessage objects.
     */
    public List<ContactMessage> getAllMessages() {
        List<ContactMessage> messages = new ArrayList<>();
        String sql = "SELECT * FROM contact_messages ORDER BY submission_date DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                ContactMessage message = new ContactMessage();
                message.setMessageId(rs.getInt("message_id"));
                message.setSenderName(rs.getString("sender_name"));
                message.setSenderEmail(rs.getString("sender_email"));
                message.setMessageText(rs.getString("message_text"));
                message.setSubmissionDate(rs.getTimestamp("submission_date"));
                messages.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messages;
    }
}