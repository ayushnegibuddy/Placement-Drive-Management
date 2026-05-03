package service;

import dao.ApplicationDAO;
import model.Application;

public class ApplicationService {
    private ApplicationDAO applicationDAO;

    public ApplicationService() {
        this.applicationDAO = new ApplicationDAO();
    }

    public boolean applyForDrive(String studentIdStr, String driveIdStr) {
        try {
            int studentId = Integer.parseInt(studentIdStr);
            int driveId = Integer.parseInt(driveIdStr);
            
            Application app = new Application(0, studentId, driveId, "Applied");
            return applicationDAO.addApplication(app);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public boolean updateApplicationStatus(String applicationIdStr, String newStatus) {
        try {
            int applicationId = Integer.parseInt(applicationIdStr);
            if (newStatus == null || newStatus.trim().isEmpty()) {
                return false;
            }
            return applicationDAO.updateStatus(applicationId, newStatus);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
