package dao;

import model.Application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ApplicationDAO {
    
    public boolean addApplication(Application app) {
        String query = "INSERT INTO applications (student_id, drive_id, status) VALUES (?, ?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, app.getStudentId());
            stmt.setInt(2, app.getDriveId());
            stmt.setString(3, app.getStatus());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding application: " + e.getMessage());
            return false;
        }
    }

    public boolean updateStatus(int applicationId, String newStatus) {
        String query = "UPDATE applications SET status = ? WHERE id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setString(1, newStatus);
            stmt.setInt(2, applicationId);
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error updating application status: " + e.getMessage());
            return false;
        }
    }
}
