package com.anantpandey.portfolio.dao;

import com.anantpandey.portfolio.db.DatabaseConnection;
import com.anantpandey.portfolio.model.Skill;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkillDAO {

    public void addSkill(Skill skill) {
        String sql = "INSERT INTO skills (skill_name, proficiency, skill_description, skill_category) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, skill.getSkillName());
            pstmt.setInt(2, skill.getProficiency());
            pstmt.setString(3, skill.getSkillDescription());
            pstmt.setString(4, skill.getSkillCategory());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

 // In SkillDAO.java

    public List<Skill> getAllSkills() {
        List<Skill> skills = new ArrayList<>();
        // Updated SQL to sort by category first, then by proficiency (highest first)
        String sql = "SELECT * FROM skills ORDER BY skill_category, proficiency DESC";
        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Skill skill = new Skill();
                skill.setSkillId(rs.getInt("skill_id"));
                skill.setSkillName(rs.getString("skill_name"));
                skill.setProficiency(rs.getInt("proficiency"));
                skill.setSkillDescription(rs.getString("skill_description"));
                skill.setSkillCategory(rs.getString("skill_category"));
                skills.add(skill);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skills;
    }
    
    public Skill getSkillById(int skillId) {
        Skill skill = null;
        String sql = "SELECT * FROM skills WHERE skill_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, skillId);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    skill = new Skill();
                    skill.setSkillId(rs.getInt("skill_id"));
                    skill.setSkillName(rs.getString("skill_name"));
                    skill.setProficiency(rs.getInt("proficiency"));
                    skill.setSkillDescription(rs.getString("skill_description"));
                    skill.setSkillCategory(rs.getString("skill_category"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return skill;
    }

    public void updateSkill(Skill skill) {
        String sql = "UPDATE skills SET skill_name = ?, proficiency = ?, skill_description = ?, skill_category = ? WHERE skill_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, skill.getSkillName());
            pstmt.setInt(2, skill.getProficiency());
            pstmt.setString(3, skill.getSkillDescription());
            pstmt.setString(4, skill.getSkillCategory());
            pstmt.setInt(5, skill.getSkillId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteSkill(int skillId) {
        String sql = "DELETE FROM skills WHERE skill_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, skillId);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}