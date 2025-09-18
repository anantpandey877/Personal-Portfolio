<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.anantpandey.portfolio.model.ContactMessage, java.text.SimpleDateFormat" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Contact Messages</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/admin-style.css">
</head>
<body>
    <div class="container">
        <h1>Contact Form Messages</h1>
        <p><a href="<%= request.getContextPath() %>/admin/dashboard.jsp">Back to Dashboard</a></p>
        
        <table>
            <thead>
                <tr>
                    <th>From</th>
                    <th>Email</th>
                    <th>Message</th>
                    <th>Received On</th>
                </tr>
            </thead>
            <tbody>
                <%
                    List<ContactMessage> messageList = (List<ContactMessage>) request.getAttribute("messageList");
                    if (messageList != null && !messageList.isEmpty()) {
                        SimpleDateFormat sdf = new SimpleDateFormat("MMM dd, yyyy 'at' hh:mm a");
                        for (ContactMessage message : messageList) {
                %>
                    <tr>
                        <td><%= message.getSenderName() %></td>
                        <td><%= message.getSenderEmail() %></td>
                        <td><%= message.getMessageText() %></td>
                        <td><%= sdf.format(message.getSubmissionDate()) %></td>
                    </tr>
                <%
                        }
                    } else {
                %>
                    <tr>
                        <td colspan="4">No messages found.</td>
                    </tr>
                <%
                    }
                %>
            </tbody>
        </table>
    </div>
</body>
</html>