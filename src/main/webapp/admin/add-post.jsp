<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Blog Post</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>
    <div class="container">
        <h1>Create a New Blog Post</h1>
        <%-- The enctype attribute is CRUCIAL for file uploads --%>
        <form action="<%= request.getContextPath() %>/admin/add-post" method="post" enctype="multipart/form-data">
            <label for="title">Title:</label>
            <input type="text" id="title" name="title" required>

            <label for="content">Content:</label>
            <textarea id="content" name="content" rows="10" required></textarea>

            <label for="author">Author:</label>
            <input type="text" id="author" name="author">

            <label for="coverImage">Cover Image:</label>
            <input type="file" id="coverImage" name="coverImage">
            <br><br>
            <button type="submit">Publish Post</button>
        </form>
    </div>
</body>
</html>