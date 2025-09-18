package com.anantpandey.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anantpandey.portfolio.db.DatabaseConnection;
import com.anantpandey.portfolio.model.BlogPost;

public class BlogPostDAO {

    public void addPost(BlogPost post) {
        String sql = "INSERT INTO blog_posts (title, content, cover_image_path, author) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getCoverImagePath());
            pstmt.setString(4, post.getAuthor());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    


    public List<BlogPost> getAllPosts() {
        List<BlogPost> posts = new ArrayList<>();
        String sql = "SELECT * FROM blog_posts ORDER BY created_at DESC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                BlogPost post = new BlogPost();
                post.setPostId(rs.getInt("post_id"));
                post.setTitle(rs.getString("title"));
                post.setContent(rs.getString("content"));
                post.setCoverImagePath(rs.getString("cover_image_path"));
                post.setAuthor(rs.getString("author"));
                post.setCreatedAt(rs.getTimestamp("created_at"));
                posts.add(post);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return posts;
    }
    
    
 // Add this method inside BlogPostDAO.java

    public BlogPost getPostById(int postId) {
        BlogPost post = null;
        String sql = "SELECT * FROM blog_posts WHERE post_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, postId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    post = new BlogPost();
                    post.setPostId(rs.getInt("post_id"));
                    post.setTitle(rs.getString("title"));
                    post.setContent(rs.getString("content"));
                    post.setCoverImagePath(rs.getString("cover_image_path"));
                    post.setAuthor(rs.getString("author"));
                    post.setCreatedAt(rs.getTimestamp("created_at"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return post;
    }
}