package com.anantpandey.portfolio.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter to protect all pages under the /admin/ path.
 */
@WebFilter("/admin/*")
public class AuthFilter implements Filter {

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        HttpSession session = request.getSession(false);

        String loginURI = request.getContextPath() + "/admin/login.jsp";
        String loginServletURI = request.getContextPath() + "/admin-login";

        boolean loggedIn = session != null && session.getAttribute("adminUser") != null;
        boolean loginRequest = request.getRequestURI().equals(loginURI);
        boolean loginServletRequest = request.getRequestURI().equals(loginServletURI);

        if (loggedIn || loginRequest || loginServletRequest) {
            // User is logged in or is trying to log in, continue the request.
            chain.doFilter(request, response);
        } else {
            // User is not logged in, redirect to the login page.
            response.sendRedirect(loginURI);
        }
    }
}