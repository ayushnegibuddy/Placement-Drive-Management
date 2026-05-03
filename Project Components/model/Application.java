package model;

public class Application {
    private int id;
    private int studentId;
    private int driveId;
    private String status;

    public Application() {}

    public Application(int id, int studentId, int driveId, String status) {
        this.id = id;
        this.studentId = studentId;
        this.driveId = driveId;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getStudentId() { return studentId; }
    public void setStudentId(int studentId) { this.studentId = studentId; }
    public int getDriveId() { return driveId; }
    public void setDriveId(int driveId) { this.driveId = driveId; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
