<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.anantpandey.portfolio.model.Project" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Project</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>
    <div class="container">
        <h1>Edit Project</h1>
        <%
            Project project = (Project) request.getAttribute("project");
            if (project != null) {
        %>
        <form action="<%= request.getContextPath() %>/admin/edit-project" method="post">
            
            <input type="hidden" name="id" value="<%= project.getProjectId() %>">

            <label for="title">Title:</label>
            <input type="text" id="title" name="title" value="<%= project.getTitle() %>" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="5" required><%= project.getDescription() %></textarea>

            <label for="techStack">Tech Stack (comma-separated):</label>
            <input type="text" id="techStack" name="techStack" value="<%= project.getTechStack() %>" required>

            <label for="githubLink">GitHub Link:</label>
            <input type="url" id="githubLink" name="githubLink" value="<%= project.getGithubLink() %>">

            <label for="liveDemoLink">Live Demo Link:</label>
            <input type="url" id="liveDemoLink" name="liveDemoLink" value="<%= project.getLiveDemoLink() %>">

            <button type="submit">Update Project</button>
        </form>
        <%
            } else {
        %>
            <p>Project not found.</p>
        <%
            }
        %>
    </div>
</body>
</html>