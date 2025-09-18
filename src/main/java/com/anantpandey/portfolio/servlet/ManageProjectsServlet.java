package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.ProjectDAO;
import com.anantpandey.portfolio.model.Project;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Fetches and displays all projects in the admin panel.
 */
@WebServlet("/admin/manage-projects")
public class ManageProjectsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;

    @Override
    public void init() {
        projectDAO = new ProjectDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<Project> allProjects = projectDAO.getAllProjects();
        request.setAttribute("projectList", allProjects);
        request.getRequestDispatcher("/admin/manage-projects.jsp").forward(request, response);
    }
}