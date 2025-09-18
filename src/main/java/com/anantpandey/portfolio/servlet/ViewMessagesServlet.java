package com.anantpandey.portfolio.servlet;

import com.anantpandey.portfolio.dao.ContactMessageDAO;
import com.anantpandey.portfolio.model.ContactMessage;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Fetches and displays all contact messages in the admin panel.
 */
@WebServlet("/admin/view-messages")
public class ViewMessagesServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ContactMessageDAO contactMessageDAO;

    @Override
    public void init() {
        contactMessageDAO = new ContactMessageDAO();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        List<ContactMessage> messageList = contactMessageDAO.getAllMessages();
        request.setAttribute("messageList", messageList);
        request.getRequestDispatcher("/admin/view-messages.jsp").forward(request, response);
    }
}