<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.List, com.anantpandey.portfolio.model.Skill" %>

<div class="skills-container">
    <div class="skills-category">
        <h3>Learned Skills</h3>
        <div class="skills-grid">
        <%
            List<Skill> learnedSkills = (List<Skill>) request.getAttribute("learnedSkills");
            if (learnedSkills != null && !learnedSkills.isEmpty()) {
                for (Skill skill : learnedSkills) {
        %>
            <div class="skill-item">
                <h3><%= skill.getSkillName() %></h3>
                <%-- Proficiency is now removed --%>
                <p class="skill-description"><%= skill.getSkillDescription() != null ? skill.getSkillDescription() : "" %></p>
            </div>
        <%
                }
            } else {
        %>
             <p>No learned skills to display.</p>
        <%  } %>
        </div>
    </div>
    <div class="skills-category">
        <h3>Currently Learning</h3>
        <div class="skills-grid">
        <%
            List<Skill> learningSkills = (List<Skill>) request.getAttribute("learningSkills");
            if (learningSkills != null && !learningSkills.isEmpty()) {
                for (Skill skill : learningSkills) {
        %>
            <div class="skill-item">
                <h3><%= skill.getSkillName() %></h3>
                <%-- Proficiency is now removed --%>
                <p class="skill-description"><%= skill.getSkillDescription() != null ? skill.getSkillDescription() : "" %></p>
            </div>
        <%
                }
            } else {
        %>
            <p>No skills currently being learned.</p>
        <% } %>
        </div>
    </div>
</div>