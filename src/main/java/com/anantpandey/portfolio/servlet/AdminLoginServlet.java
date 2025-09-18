package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.AdminDAO;
import com.anantpandey.portfolio.model.Admin;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;
import java.io.IOException;

/**
 * Handles the admin login authentication.
 */
@WebServlet("/admin-login")
public class AdminLoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AdminDAO adminDAO;

    @Override
    public void init() {
        adminDAO = new AdminDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        Admin admin = adminDAO.getAdminByUsername(username);

        if (admin != null && BCrypt.checkpw(password, admin.getPasswordHash())) {
            // Login successful
            HttpSession session = request.getSession();
            session.setAttribute("adminUser", admin);
            response.sendRedirect(request.getContextPath() + "/admin/dashboard.jsp");
        } else {
            // Login failed
            request.setAttribute("errorMessage", "Invalid username or password.");
            request.getRequestDispatcher("/admin/login.jsp").forward(request, response);
        }
    }
}