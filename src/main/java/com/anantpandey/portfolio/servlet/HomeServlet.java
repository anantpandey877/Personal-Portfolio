package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.ProjectDAO;
import com.anantpandey.portfolio.dao.SkillDAO;
import com.anantpandey.portfolio.model.Project;
import com.anantpandey.portfolio.model.Skill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("") // Mapped to the root URL
public class HomeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProjectDAO projectDAO;
    private SkillDAO skillDAO;

    @Override
    public void init() {
        projectDAO = new ProjectDAO();
        skillDAO = new SkillDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Fetch Projects
        List<Project> projectList = projectDAO.getAllProjects();
        request.setAttribute("projectList", projectList);

        // Fetch and process Skills
        List<Skill> allSkills = skillDAO.getAllSkills();
        List<Skill> learnedSkills = new ArrayList<>();
        List<Skill> learningSkills = new ArrayList<>();

        for (Skill skill : allSkills) {
            if ("Learned".equalsIgnoreCase(skill.getSkillCategory())) {
                learnedSkills.add(skill);
            } else {
                learningSkills.add(skill);
            }
        }

        request.setAttribute("learnedSkills", learnedSkills);
        request.setAttribute("learningSkills", learningSkills);

        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
}