package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.ContactMessageDAO;
import com.anantpandey.portfolio.model.ContactMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Handles submissions from the public contact form.
 */
@WebServlet("/contact")
public class ContactServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactMessageDAO contactMessageDAO;

    @Override
    public void init() {
        contactMessageDAO = new ContactMessageDAO();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String messageText = request.getParameter("message");
        
        ContactMessage message = new ContactMessage();
        message.setSenderName(name);
        message.setSenderEmail(email);
        message.setMessageText(messageText);
        
        contactMessageDAO.saveMessage(message);
        
        response.sendRedirect(request.getContextPath() + "/thank-you.jsp");
    }
}