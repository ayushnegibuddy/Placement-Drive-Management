package model;

public class Interview {
    private int id;
    private int applicationId;
    private String interviewTime;

    public Interview() {}

    public Interview(int id, int applicationId, String interviewTime) {
        this.id = id;
        this.applicationId = applicationId;
        this.interviewTime = interviewTime;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getApplicationId() { return applicationId; }
    public void setApplicationId(int applicationId) { this.applicationId = applicationId; }
    public String getInterviewTime() { return interviewTime; }
    public void setInterviewTime(String interviewTime) { this.interviewTime = interviewTime; }
}
