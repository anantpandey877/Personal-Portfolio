<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.anantpandey.portfolio.model.Project"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manage Projects</title>

<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/admin-style.css">
</head>
<body>
	<div class="container">
		<h1>Manage Projects</h1>
		<p>
			<a href="<%=request.getContextPath()%>/admin/dashboard.jsp">Back
				to Dashboard</a>
		</p>

		<table>
			<thead>
				<tr>
					<th>ID</th>
					<th>Title</th>
					<th>Tech Stack</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<%
				List<Project> projectList = (List<Project>) request.getAttribute("projectList");
				if (projectList != null && !projectList.isEmpty()) {
					for (Project project : projectList) {
				%>
				<tr>
					<td><%=project.getProjectId()%></td>
					<td><%=project.getTitle()%></td>
					<td><%=project.getTechStack()%></td>
					<td><a
						href="<%=request.getContextPath()%>/admin/edit-project?id=<%=project.getProjectId()%>">Edit</a>
						| <a
						href="<%=request.getContextPath()%>/admin/delete-project?id=<%=project.getProjectId()%>"
						onclick="return confirm('Are you sure you want to delete this project?');">Delete</a>
					</td>
				</tr>
				<%
				}
				} else {
				%>
				<tr>
					<td colspan="4">No projects found.</td>
				</tr>
				<%
				}
				%>
			</tbody>
		</table>
	</div>
</body>
</html>