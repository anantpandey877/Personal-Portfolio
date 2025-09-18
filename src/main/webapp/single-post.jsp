<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="com.anantpandey.portfolio.model.BlogPost, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <%
        BlogPost post = (BlogPost) request.getAttribute("post");
        String pageTitle = (post != null) ? post.getTitle() : "Post Not Found";
    %>
    <title><%= pageTitle %></title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>

    <jsp:include page="/fragments/header.jsp" />

    <main class="container">
        <div class="single-post-container">
        <%
            if (post != null) {
                SimpleDateFormat sdf = new SimpleDateFormat("MMMM dd, yyyy");
        %>
            <div class="post-header">
                <h1><%= post.getTitle() %></h1>
                <p class="post-meta">By <%= post.getAuthor() %> on <%= sdf.format(post.getCreatedAt()) %></p>
            </div>

            <% if (post.getCoverImagePath() != null && !post.getCoverImagePath().isEmpty()) { %>
                <img class="post-image" src="<%= request.getContextPath() %>/<%= post.getCoverImagePath() %>" alt="<%= post.getTitle() %>">
            <% } %>

            <div class="post-content">
                <%= post.getContent() %>
            </div>

        <% } else { %>
            <h1>Post Not Found</h1>
            <p>The post you are looking for does not exist.</p>
        <% } %>
        </div>
    </main>

    <jsp:include page="/fragments/footer.jsp" />

</body>
</html>