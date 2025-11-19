package Models;

import java.sql.Date;

public class Drive {
    private int driveId;
    private String title;
    private int companyId;
    private Date scheduledDate;
    private Integer adminId; // nullable

    public Drive() {
    }

    public Drive(int driveId, String title, int companyId, Date scheduledDate, Integer adminId) {
        this.driveId = driveId;
        this.title = title;
        this.companyId = companyId;
        this.scheduledDate = scheduledDate;
        this.adminId = adminId;
    }

    public Drive(String title, int companyId, Date scheduledDate, Integer adminId) {
        this.title = title;
        this.companyId = companyId;
        this.scheduledDate = scheduledDate;
        this.adminId = adminId;
    }

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }

    public Integer getAdminId() {
        return adminId;
    }

    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }
}

