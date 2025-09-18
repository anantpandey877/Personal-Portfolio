<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Project</title>


<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>
    <div class="container">
        <h1>Add a New Project</h1>
        <form action="<%= request.getContextPath() %>/admin/add-project" method="post">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>

            <label for="description">Description:</label>
            <textarea id="description" name="description" rows="5" required></textarea>

            <label for="techStack">Tech Stack (comma-separated):</label>
            <input type="text" id="techStack" name="techStack" required>

            <label for="githubLink">GitHub Link:</label>
            <input type="url" id="githubLink" name="githubLink">

            <label for="liveDemoLink">Live Demo Link:</label>
            <input type="url" id="liveDemoLink" name="liveDemoLink">

            <button type="submit">Add Project</button>
        </form>
    </div>
</body>
</html>