package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.SkillDAO;
import com.anantpandey.portfolio.model.Skill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/add-skill")
public class AddSkillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SkillDAO skillDAO;

    @Override
    public void init() {
        skillDAO = new SkillDAO();
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String skillName = request.getParameter("skillName");
        int proficiency = Integer.parseInt(request.getParameter("proficiency"));
        String skillCategory = request.getParameter("skillCategory");
        String skillDescription = request.getParameter("skillDescription");

        Skill skill = new Skill();
        skill.setSkillName(skillName);
        skill.setProficiency(proficiency);
        skill.setSkillCategory(skillCategory);
        skill.setSkillDescription(skillDescription);

        skillDAO.addSkill(skill);

        // Set a success message in the session
        request.getSession().setAttribute("successMessage", "Skill '" + skillName + "' was added successfully!");

        // Redirect back to the add skill page
        response.sendRedirect(request.getContextPath() + "/admin/add-skill.jsp");
    }
}