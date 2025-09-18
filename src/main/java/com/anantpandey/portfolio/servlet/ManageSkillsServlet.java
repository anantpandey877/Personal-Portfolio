package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.SkillDAO;
import com.anantpandey.portfolio.model.Skill;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/manage-skills")
public class ManageSkillsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SkillDAO skillDAO;

    @Override
    public void init() {
        skillDAO = new SkillDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Skill> allSkills = skillDAO.getAllSkills();
        request.setAttribute("skillList", allSkills);
        request.getRequestDispatcher("/admin/manage-skills.jsp").forward(request, response);
    }
}