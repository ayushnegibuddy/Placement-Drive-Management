package dao;

import model.Interview;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InterviewDAO {
    
    public boolean scheduleInterview(Interview interview) {
        String query = "INSERT INTO interviews (application_id, interview_time) VALUES (?, ?)";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query)) {
             
            stmt.setInt(1, interview.getApplicationId());
            stmt.setString(2, interview.getInterviewTime());
            
            int rowsAffected = stmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            System.err.println("Error scheduling interview: " + e.getMessage());
            return false;
        }
    }
}
