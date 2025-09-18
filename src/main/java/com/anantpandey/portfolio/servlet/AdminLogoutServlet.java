package com.anantpandey.portfolio.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Handles the admin logout process.
 */
@WebServlet("/admin-logout")
public class AdminLogoutServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        HttpSession session = request.getSession(false); // Get session if it exists.
        
        if (session != null) {
            session.invalidate(); // Invalidate the session.
        }
        
        // Redirect back to the login page.
        response.sendRedirect(request.getContextPath() + "/admin/login.jsp");
    }
}