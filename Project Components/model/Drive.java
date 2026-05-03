package model;

public class Drive {
    private int id;
    private int companyId;
    private String driveDate;

    public Drive() {}

    public Drive(int id, int companyId, String driveDate) {
        this.id = id;
        this.companyId = companyId;
        this.driveDate = driveDate;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public int getCompanyId() { return companyId; }
    public void setCompanyId(int companyId) { this.companyId = companyId; }
    public String getDriveDate() { return driveDate; }
    public void setDriveDate(String driveDate) { this.driveDate = driveDate; }
}
