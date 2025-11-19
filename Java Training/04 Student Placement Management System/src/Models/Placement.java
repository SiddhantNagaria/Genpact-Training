package Models;

import java.math.BigDecimal;

public class Placement {
    private int placementId;
    private int studentId;
    private int companyId;
    private int driveId;
    private String role;
    private String status;
    private BigDecimal packageLpa;

    public Placement() {
    }

    public Placement(int placementId, int studentId, int companyId, int driveId, String role, String status, BigDecimal packageLpa) {
        this.placementId = placementId;
        this.studentId = studentId;
        this.companyId = companyId;
        this.driveId = driveId;
        this.role = role;
        this.status = status;
        this.packageLpa = packageLpa;
    }

    public Placement(int studentId, int companyId, int driveId, String role, String status, BigDecimal packageLpa) {
        this.studentId = studentId;
        this.companyId = companyId;
        this.driveId = driveId;
        this.role = role;
        this.status = status;
        this.packageLpa = packageLpa;
    }

    public int getPlacementId() {
        return placementId;
    }

    public void setPlacementId(int placementId) {
        this.placementId = placementId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public int getDriveId() {
        return driveId;
    }

    public void setDriveId(int driveId) {
        this.driveId = driveId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public BigDecimal getPackageLpa() {
        return packageLpa;
    }

    public void setPackageLpa(BigDecimal packageLpa) {
        this.packageLpa = packageLpa;
    }
}

