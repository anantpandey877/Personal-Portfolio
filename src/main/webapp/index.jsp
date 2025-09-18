<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Anant Pandey - Portfolio</title>
    <link rel="stylesheet" type="text/css" href="<%= request.getContextPath() %>/css/style.css">
    <%-- Add this line for icons --%>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.5.2/css/all.min.css">
</head>
<body>

    <%-- Include the reusable header --%>
    <jsp:include page="/fragments/header.jsp" />

    <main class="container">
        <section id="hero">
            <div class="hero-content">
                <h1>Hello, I'm Anant Pandey</h1>
                <p class="tagline">A Java Full-Stack Developer Crafting Digital Solutions.</p>
                <a href="#projects" class="btn-primary">View My Work</a>
            </div>
        </section>
        
       <jsp:include page="/fragments/project-list.jsp" />
       
     <section id="about">
    <h2>About & Skills</h2>
    <p>
        I am a passionate Java developer with a strong foundation in object-oriented programming and web development. My expertise lies in building robust, scalable backend systems using the technologies listed below.
    </p>

    <%-- Include the skills list fragment --%>
    <jsp:include page="/fragments/skills-list.jsp" />
</section>

<section id="resume">
    <h2>My Resume</h2>
    <p>Feel free to view my resume online or download a copy for your records.</p>
    <div class="resume-controls">
        <%-- This button opens the PDF in a new tab --%>
        <a href="<%= request.getContextPath() %>/assets/pdf/Resume - Anant Pandey.pdf" class="btn-primary" target="_blank">
            View Resume
        </a>

        <%-- This button starts a download --%>
        <a href="<%= request.getContextPath() %>/assets/pdf/Resume - Anant Pandey.pdf" class="btn-primary" download>
            Download Resume
        </a>
    </div>
</section>

    <section id="contact">
        <h2>Get In Touch</h2>
        <p>Have a question or want to work together? Leave your details and I'll get back to you.</p>
        <form action="<%= request.getContextPath() %>/contact" method="post" class="contact-form">
            <input type="text" name="name" placeholder="Your Name" required>
            <input type="email" name="email" placeholder="Your Email" required>
            <textarea name="message" rows="5" placeholder="Your Message" required></textarea>
            <button type="submit" class="btn-primary">Send Message</button>
        </form>
    </section>
    
 


        
    </main>

    <%-- Include the reusable footer --%>
    <jsp:include page="/fragments/footer.jsp" />
    <script src="<%= request.getContextPath() %>/js/terminal.js"></script>

</body>
</html>