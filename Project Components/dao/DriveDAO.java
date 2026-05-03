package dao;

import model.Drive;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DriveDAO {
    
    public boolean addDrive(Drive drive) {
        String query = "INSERT INTO drives (company_id, drive_date) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, drive.getCompanyId());
            stmt.setString(2, drive.getDriveDate());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error adding drive: " + e.getMessage());
            return false;
        }
    }
}
