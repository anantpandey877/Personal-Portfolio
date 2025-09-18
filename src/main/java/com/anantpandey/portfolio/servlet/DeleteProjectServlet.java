package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.ProjectDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles the deletion of a project.
 */
@WebServlet("/admin/delete-project")
public class DeleteProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;

    @Override
    public void init() {
        projectDAO = new ProjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        try {
            int id = Integer.parseInt(request.getParameter("id"));
            projectDAO.deleteProject(id);
        } catch (NumberFormatException e) {
            // Handle cases where ID is not a valid number
            e.printStackTrace();
        }
        
        response.sendRedirect(request.getContextPath() + "/admin/manage-projects");
    }
}