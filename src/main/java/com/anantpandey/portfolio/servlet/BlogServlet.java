package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.BlogPostDAO;
import com.anantpandey.portfolio.model.BlogPost;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/blog")
public class BlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogPostDAO blogPostDAO;

    @Override
    public void init() {
        blogPostDAO = new BlogPostDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<BlogPost> postList = blogPostDAO.getAllPosts();
        request.setAttribute("postList", postList);
        request.getRequestDispatcher("/blog.jsp").forward(request, response);
    }
}