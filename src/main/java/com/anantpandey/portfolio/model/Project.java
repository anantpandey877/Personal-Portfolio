package com.anantpandey.portfolio.model;

/**
 * This is a POJO (Plain Old Java Object) or a JavaBean that represents
 * a single project from our database.
 */
public class Project {

    // --- Private Member Variables ---
    // These directly correspond to the columns in our 'projects' table.
    private int projectId;
    private String title;
    private String description;
    private String techStack;
    private String githubLink;
    private String liveDemoLink;
    private String imageUrl;

    // --- Constructors ---
    /**
     * Default no-argument constructor (required for a JavaBean).
     */
    public Project() {
    }

    /**
     * Constructor with all fields for easier object creation.
     */
    public Project(int projectId, String title, String description, String techStack, String githubLink, String liveDemoLink, String imageUrl) {
        this.projectId = projectId;
        this.title = title;
        this.description = description;
        this.techStack = techStack;
        this.githubLink = githubLink;
        this.liveDemoLink = liveDemoLink;
        this.imageUrl = imageUrl;
    }

    // --- Getters and Setters ---
    // These allow other classes to safely access and modify the private variables.
    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTechStack() {
        return techStack;
    }

    public void setTechStack(String techStack) {
        this.techStack = techStack;
    }

    public String getGithubLink() {
        return githubLink;
    }

    public void setGithubLink(String githubLink) {
        this.githubLink = githubLink;
    }

    public String getLiveDemoLink() {
        return liveDemoLink;
    }

    public void setLiveDemoLink(String liveDemoLink) {
        this.liveDemoLink = liveDemoLink;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    // --- toString() Method (Optional but good for debugging) ---
    @Override
    public String toString() {
        return "Project{" +
                "projectId=" + projectId +
                ", title='" + title + '\'' +
                '}';
    }
}