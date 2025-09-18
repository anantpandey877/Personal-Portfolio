package com.anantpandey.portfolio.model;

import java.sql.Timestamp;

public class BlogPost {
    private int postId;
    private String title;
    private String content;
    private String coverImagePath;
    private String author;
    private Timestamp createdAt;

    // Getters and Setters
    public int getPostId() { return postId; }
    public void setPostId(int postId) { this.postId = postId; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContent() { return content; }
    public void setContent(String content) { this.content = content; }
    public String getCoverImagePath() { return coverImagePath; }
    public void setCoverImagePath(String coverImagePath) { this.coverImagePath = coverImagePath; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
    public Timestamp getCreatedAt() { return createdAt; }
    public void setCreatedAt(Timestamp createdAt) { this.createdAt = createdAt; }
}