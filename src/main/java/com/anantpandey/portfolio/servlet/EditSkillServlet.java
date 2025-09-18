package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.SkillDAO;
import com.anantpandey.portfolio.model.Skill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/admin/edit-skill")
public class EditSkillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SkillDAO skillDAO;

    @Override
    public void init() {
        skillDAO = new SkillDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Skill skill = skillDAO.getSkillById(id);
        request.setAttribute("skill", skill);
        request.getRequestDispatcher("/admin/edit-skill.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int skillId = Integer.parseInt(request.getParameter("skillId"));
        String skillName = request.getParameter("skillName");
        int proficiency = Integer.parseInt(request.getParameter("proficiency"));
        String skillCategory = request.getParameter("skillCategory");
        String skillDescription = request.getParameter("skillDescription");

        Skill skill = new Skill();
        skill.setSkillId(skillId);
        skill.setSkillName(skillName);
        skill.setProficiency(proficiency);
        skill.setSkillCategory(skillCategory);
        skill.setSkillDescription(skillDescription);

        skillDAO.updateSkill(skill);
        response.sendRedirect(request.getContextPath() + "/admin/manage-skills");
    }
}