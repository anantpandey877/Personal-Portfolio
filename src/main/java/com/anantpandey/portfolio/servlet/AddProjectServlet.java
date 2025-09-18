package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.ProjectDAO;
import com.anantpandey.portfolio.model.Project;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles the submission of the 'Add New Project' form.
 */
@WebServlet("/admin/add-project")
public class AddProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;

    @Override
    public void init() {
        projectDAO = new ProjectDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Retrieve form parameters
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String techStack = request.getParameter("techStack");
        String githubLink = request.getParameter("githubLink");
        String liveDemoLink = request.getParameter("liveDemoLink");

        // Create a new Project object
        Project newProject = new Project();
        newProject.setTitle(title);
        newProject.setDescription(description);
        newProject.setTechStack(techStack);
        newProject.setGithubLink(githubLink);
        newProject.setLiveDemoLink(liveDemoLink);

        // Save the project to the database
        projectDAO.addProject(newProject);

        // Redirect to a confirmation or management page
        response.sendRedirect(request.getContextPath() + "/project-list"); // For now, redirect to the public projects list
    }
}