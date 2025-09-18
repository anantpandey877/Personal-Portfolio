<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add New Skill</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>
    <div class="container">
        <h1>Add a New Skill</h1>
        
        <%
            String successMessage = (String) session.getAttribute("successMessage");
            if (successMessage != null) {
        %>
            <div style="color: green; border: 1px solid green; padding: 10px; margin-bottom: 15px;">
                <%= successMessage %>
            </div>
        <%
            session.removeAttribute("successMessage");
            }
        %>

        <form action="<%= request.getContextPath() %>/admin/add-skill" method="post">
            <label for="skillName">Skill Name:</label>
            <input type="text" id="skillName" name="skillName" required>

            <label for="proficiency">Proficiency (0-100):</label>
            <input type="number" id="proficiency" name="proficiency" min="0" max="100">
            
            <label for="skillDescription">Description:</label>
            <textarea id="skillDescription" name="skillDescription" rows="3"></textarea>

            <label for="skillCategory">Category:</label>
            <select id="skillCategory" name="skillCategory" required>
                <option value="Learned">Learned</option>
                <option value="Learning">Currently Learning</option>
            </select>
            <br><br>
            <button type="submit">Add Skill</button>
        </form>
    </div>
</body>
</html>