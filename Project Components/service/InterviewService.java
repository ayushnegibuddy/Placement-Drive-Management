package service;

import dao.InterviewDAO;
import model.Interview;

public class InterviewService {
    private InterviewDAO interviewDAO;

    public InterviewService() {
        this.interviewDAO = new InterviewDAO();
    }

    public boolean scheduleInterview(String applicationIdStr, String time) {
        try {
            int applicationId = Integer.parseInt(applicationIdStr);
            if (time == null || time.trim().isEmpty()) {
                return false;
            }
            Interview interview = new Interview(0, applicationId, time);
            return interviewDAO.scheduleInterview(interview);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
