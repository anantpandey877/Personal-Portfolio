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
 * Handles both displaying and processing the edit project form.
 */
@WebServlet("/admin/edit-project")
public class EditProjectServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;

    @Override
    public void init() {
        projectDAO = new ProjectDAO();
    }

    // This method shows the edit form with the project's existing data
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Project existingProject = projectDAO.getProjectById(id);
        request.setAttribute("project", existingProject);
        request.getRequestDispatcher("/admin/edit-project.jsp").forward(request, response);
    }

    // This method processes the submitted form and updates the database
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        int id = Integer.parseInt(request.getParameter("id"));
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        String techStack = request.getParameter("techStack");
        String githubLink = request.getParameter("githubLink");
        String liveDemoLink = request.getParameter("liveDemoLink");
        
        Project project = new Project();
        project.setProjectId(id);
        project.setTitle(title);
        project.setDescription(description);
        project.setTechStack(techStack);
        project.setGithubLink(githubLink);
        project.setLiveDemoLink(liveDemoLink);

        projectDAO.updateProject(project);
        response.sendRedirect(request.getContextPath() + "/admin/manage-projects");
    }
}