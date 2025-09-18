<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.anantpandey.portfolio.model.Skill" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Skills</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>
    <div class="container">
        <h1>Manage Skills</h1>
        <p><a href="<%= request.getContextPath() %>/admin/dashboard.jsp">Back to Dashboard</a></p>

        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Skill Name</th>
                    <th>Category</th>
                    <th>Proficiency</th>
                    <th>Actions</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<Skill> skillList = (List<Skill>) request.getAttribute("skillList");
                    if (skillList != null && !skillList.isEmpty()) {
                        for (Skill skill : skillList) {
                %>
                    <tr>
                        <td><%= skill.getSkillId() %></td>
                        <td><%= skill.getSkillName() %></td>
                        <td><%= skill.getSkillCategory() %></td>
                        <td><%= skill.getProficiency() %>%</td>
                        <td>
    <a href="<%= request.getContextPath() %>/admin/edit-skill?id=<%= skill.getSkillId() %>">Edit</a> |
    <a href="<%= request.getContextPath() %>/admin/delete-skill?id=<%= skill.getSkillId() %>"
       onclick="return confirm('Are you sure you want to delete this skill?');">Delete</a>
</td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="5">No skills found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>