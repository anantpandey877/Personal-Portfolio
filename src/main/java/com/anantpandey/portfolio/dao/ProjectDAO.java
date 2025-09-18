package com.anantpandey.portfolio.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.anantpandey.portfolio.db.DatabaseConnection;
import com.anantpandey.portfolio.model.Project;

/**
 * Handles all database operations for Project objects.
 */
public class ProjectDAO {

	/**
	 * Retrieves all projects from the database.
	 * 
	 * @return A list of Project objects.
	 */
	public List<Project> getAllProjects() {
		List<Project> projects = new ArrayList<>();
		String sql = "SELECT * FROM projects";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()) {

			while (rs.next()) {
				Project project = new Project();
				project.setProjectId(rs.getInt("project_id"));
				project.setTitle(rs.getString("title"));
				project.setDescription(rs.getString("description"));
				project.setTechStack(rs.getString("tech_stack"));
				project.setGithubLink(rs.getString("github_link"));
				project.setLiveDemoLink(rs.getString("live_demo_link"));
				project.setImageUrl(rs.getString("image_url"));
				projects.add(project);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return projects;
	}

	// Add this new method inside your ProjectDAO class

	/**
	 * Adds a new project to the database.
	 * 
	 * @param project The Project object containing the data to be inserted.
	 */
	public void addProject(Project project) {
		String sql = "INSERT INTO projects (title, description, tech_stack, github_link, live_demo_link) VALUES (?, ?, ?, ?, ?)";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, project.getTitle());
			pstmt.setString(2, project.getDescription());
			pstmt.setString(3, project.getTechStack());
			pstmt.setString(4, project.getGithubLink());
			pstmt.setString(5, project.getLiveDemoLink());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Deletes a project from the database based on its ID.
	 * 
	 * @param projectId The ID of the project to be deleted.
	 */
	public void deleteProject(int projectId) {
		String sql = "DELETE FROM projects WHERE project_id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, projectId);
			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Retrieves a single project from the database by its ID.
	 * 
	 * @param projectId The ID of the project to retrieve.
	 * @return A Project object if found, otherwise null.
	 */
	public Project getProjectById(int projectId) {
		Project project = null;
		String sql = "SELECT * FROM projects WHERE project_id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, projectId);
			try (ResultSet rs = pstmt.executeQuery()) {
				if (rs.next()) {
					project = new Project();
					project.setProjectId(rs.getInt("project_id"));
					project.setTitle(rs.getString("title"));
					project.setDescription(rs.getString("description"));
					project.setTechStack(rs.getString("tech_stack"));
					project.setGithubLink(rs.getString("github_link"));
					project.setLiveDemoLink(rs.getString("live_demo_link"));
					project.setImageUrl(rs.getString("image_url"));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return project;
	}

	/**
	 * Updates an existing project in the database.
	 * 
	 * @param project The Project object with updated information.
	 */
	public void updateProject(Project project) {
		String sql = "UPDATE projects SET title = ?, description = ?, tech_stack = ?, github_link = ?, live_demo_link = ? WHERE project_id = ?";

		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, project.getTitle());
			pstmt.setString(2, project.getDescription());
			pstmt.setString(3, project.getTechStack());
			pstmt.setString(4, project.getGithubLink());
			pstmt.setString(5, project.getLiveDemoLink());
			pstmt.setInt(6, project.getProjectId());

			pstmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}