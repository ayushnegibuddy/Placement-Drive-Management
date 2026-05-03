package service;

import dao.DriveDAO;
import model.Drive;

public class DriveService {
    private DriveDAO driveDAO;

    public DriveService() {
        this.driveDAO = new DriveDAO();
    }

    public boolean createDrive(String companyIdStr, String driveDate) {
        try {
            int companyId = Integer.parseInt(companyIdStr);
            if (driveDate == null || driveDate.trim().isEmpty()) {
                return false;
            }
            Drive drive = new Drive(0, companyId, driveDate);
            return driveDAO.addDrive(drive);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
