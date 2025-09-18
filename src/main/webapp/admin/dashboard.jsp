<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="com.anantpandey.portfolio.model.Admin"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Admin Dashboard</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/admin-style.css">
</head>
<body>
	<h1>Welcome, Admin!</h1>

	<%
	Admin admin = (Admin) session.getAttribute("adminUser");
	if (admin != null) {
	%>
	<p>
		You are logged in as: <strong><%=admin.getUsername()%></strong>
	</p>
	<hr>
	<h3>Manage Content</h3>
	<ul>
		<li><a href="<%=request.getContextPath()%>/admin/add-project.jsp">Add
				New Project</a></li>

		<li><a href="<%=request.getContextPath()%>/admin/manage-projects">Manage
				Projects</a></li>
		<%-- We will add a 'Manage Projects' link here later --%>
	</ul>

	<h3>Communications</h3>
	<ul>
		<li><a href="<%=request.getContextPath()%>/admin/view-messages">View
				Contact Messages</a></li>
	</ul>
	<h3>Manage Skills</h3>

	<ul>
		<li><a href="<%=request.getContextPath()%>/admin/add-skill.jsp">Add
				New Skill</a></li>
		<li><a href="<%=request.getContextPath()%>/admin/manage-skills">Manage
				Skills</a></li>
	</ul>


	<h3>Manage Blog</h3>
	<ul>
		<li><a href="<%=request.getContextPath()%>/admin/add-post.jsp">Add
				New Post</a></li>
	</ul>
	<hr>
	<a href="<%=request.getContextPath()%>/admin-logout">Logout</a>
	<%
	} else {
	response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
	}
	%>
</body>
</html>