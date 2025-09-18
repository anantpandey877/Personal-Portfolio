<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="java.util.List, com.anantpandey.portfolio.model.BlogPost, java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My Blog</title>
<link rel="stylesheet" type="text/css"
	href="<%=request.getContextPath()%>/css/style.css">
</head>
<body>

	<jsp:include page="/fragments/header.jsp" />

	<main class="container">
		<section id="blog-list">
			<h2>Latest Posts</h2>
			<div class="blog-grid">
				<%
				List<BlogPost> postList = (List<BlogPost>) request.getAttribute("postList");
				if (postList != null && !postList.isEmpty()) {
					SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
					for (BlogPost post : postList) {
						// Truncate content for a short preview
						String content = post.getContent();
						String preview = content.length() > 150 ? content.substring(0, 150) + "..." : content;
				%>
				<div class="project-card">
					<%-- We can reuse the project-card style for consistency --%>
					<h3><%=post.getTitle()%></h3>
					<p class="post-meta">
						By
						<%=post.getAuthor()%>
						on
						<%=sdf.format(post.getCreatedAt())%></p>
					<p class="project-description"><%=preview%></p>
					<div class="project-links">
						<%-- Inside blog.jsp --%>
						<a
							href="<%=request.getContextPath()%>/post?id=<%=post.getPostId()%>"
							class="btn">Read More</a>
					</div>
				</div>
				<%
				}
				} else {
				%>
				<p>No blog posts found.</p>
				<%
				}
				%>
			</div>
		</section>
	</main>

	<jsp:include page="/fragments/footer.jsp" />

</body>
</html>