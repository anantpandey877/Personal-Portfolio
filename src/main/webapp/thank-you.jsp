<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thank You</title>
<link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
</head>
<body>
    <div class="container" style="text-align: center; padding-top: 100px;">
        <h1>Thank You!</h1>
        <p>Your message has been sent successfully. I will get back to you shortly.</p>
        <a href="<%= request.getContextPath() %>/" class="btn-primary">Back to Home</a>
    </div>
</body>
</html>