package Models;

public class Student {
    private int studentId;
    private String rollNo;
    private String fullName;
    private String email;
    private String branch;
    private int year;
    private String status; // Not Placed / Placed / Interviewed

    public Student() {
    }

    public Student(int studentId, String rollNo, String fullName, String email, String branch, int year, String status) {
        this.studentId = studentId;
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.email = email;
        this.branch = branch;
        this.year = year;
        this.status = status;
    }

    public Student(String rollNo, String fullName, String email, String branch, int year) {
        this.rollNo = rollNo;
        this.fullName = fullName;
        this.email = email;
        this.branch = branch;
        this.year = year;
        this.status = "Not Placed";
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getRollNo() {
        return rollNo;
    }

    public void setRollNo(String rollNo) {
        this.rollNo = rollNo;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

