<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.anantpandey.portfolio.model.Project" %>

<section id="projects">
    <h2>My Projects</h2>
    <div class="project-grid">
        <%
            List<Project> projectList = (List<Project>) request.getAttribute("projectList");
            if (projectList != null && !projectList.isEmpty()) {
                for (Project project : projectList) {
        %>
            <div class="project-card">
                <h3><%= project.getTitle() %></h3>
                <p class="project-description"><%= project.getDescription() %></p>
                <div class="tech-stack">
                    <%
                        String[] techs = project.getTechStack().split(",");
                        for(String tech : techs) {
                    %>
                        <span><%= tech.trim() %></span>
                    <%
                        }
                    %>
                </div>
                <div class="project-links">
                    <a href="<%= project.getGithubLink() %>" target="_blank">GitHub</a>
                    <a href="<%= project.getLiveDemoLink() %>" target="_blank">Live Demo</a>
                </div>
            </div>
        <%
                }
            } else {
        %>
            <p>No projects to display.</p>
        <%
            }
        %>
    </div>
</section>