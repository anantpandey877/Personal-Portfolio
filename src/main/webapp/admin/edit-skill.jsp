<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.anantpandey.portfolio.model.Skill" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Skill</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>
    <div class="container">
        <h1>Edit Skill</h1>
        <%
            Skill skill = (Skill) request.getAttribute("skill");
            if (skill != null) {
        %>
        <form action="<%= request.getContextPath() %>/admin/edit-skill" method="post">
            <input type="hidden" name="skillId" value="<%= skill.getSkillId() %>">

            <label for="skillName">Skill Name:</label>
            <input type="text" id="skillName" name="skillName" value="<%= skill.getSkillName() %>" required>

            <label for="proficiency">Proficiency (0-100):</label>
            <input type="number" id="proficiency" name="proficiency" value="<%= skill.getProficiency() %>" min="0" max="100">

            <label for="skillDescription">Description:</label>
            <textarea id="skillDescription" name="skillDescription" rows="3"><%= skill.getSkillDescription() != null ? skill.getSkillDescription() : "" %></textarea>

            <label for="skillCategory">Category:</label>
            <select id="skillCategory" name="skillCategory" required>
                <option value="Learned" <%= "Learned".equals(skill.getSkillCategory()) ? "selected" : "" %>>Learned</option>
                <option value="Learning" <%= "Learning".equals(skill.getSkillCategory()) ? "selected" : "" %>>Currently Learning</option>
            </select>
            <br><br>
            <button type="submit">Update Skill</button>
        </form>
        <% } else { %>
            <p>Skill not found.</p>
        <% } %>
    </div>
</body>
</html>