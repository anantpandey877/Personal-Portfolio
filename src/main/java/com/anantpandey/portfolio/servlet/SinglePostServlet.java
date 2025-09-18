package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.BlogPostDAO;
import com.anantpandey.portfolio.model.BlogPost;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/post")
public class SinglePostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogPostDAO blogPostDAO;

    @Override
    public void init() {
        blogPostDAO = new BlogPostDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {
            int postId = Integer.parseInt(request.getParameter("id"));
            BlogPost post = blogPostDAO.getPostById(postId);
            request.setAttribute("post", post);
            request.getRequestDispatcher("/single-post.jsp").forward(request, response);
        } catch (NumberFormatException e) {
            // Handle cases where ID is not a number
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid post ID.");
        }
    }
}