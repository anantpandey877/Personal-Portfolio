package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.BlogPostDAO;
import com.anantpandey.portfolio.model.BlogPost;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import java.io.File;
import java.io.IOException;

@WebServlet("/admin/add-post")
@MultipartConfig // This annotation is required for file uploads
public class AddPostServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogPostDAO blogPostDAO;
    // Define a path on your computer where images will be stored
    private static final String UPLOAD_DIR = "uploads"; 

    @Override
    public void init() {
        blogPostDAO = new BlogPostDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get text data
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        String author = request.getParameter("author");

        // Handle file upload
        Part filePart = request.getPart("coverImage");
        String fileName = filePart.getSubmittedFileName();
        String imagePath = null;

        if (fileName != null && !fileName.isEmpty()) {
            // Creates the directory if it does not exist
            String applicationPath = request.getServletContext().getRealPath("");
            String uploadFilePath = applicationPath + File.separator + UPLOAD_DIR;
            File fileSaveDir = new File(uploadFilePath);
            if (!fileSaveDir.exists()) {
                fileSaveDir.mkdirs();
            }

            filePart.write(uploadFilePath + File.separator + fileName);
            imagePath = UPLOAD_DIR + "/" + fileName; // Store the relative path
        }

        // Save post to database
        BlogPost post = new BlogPost();
        post.setTitle(title);
        post.setContent(content);
        post.setAuthor(author);
        post.setCoverImagePath(imagePath);

        blogPostDAO.addPost(post);

        // Redirect to a management page
        response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
    }
}