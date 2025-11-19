package DAO;
import Models.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {

    public void createStudent(Student s) {
        String sql = "INSERT INTO student (roll_no, full_name, email, branch, year, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, s.getRollNo());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getBranch());
            ps.setInt(5, s.getYear());
            ps.setString(6, s.getStatus());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) {
                        int id = rs.getInt(1);
                        s.setStudentId(id);
                    }
                }
                System.out.println("Student created successfully with id: " + s.getStudentId());
            } else {
                System.out.println("Student creation failed.");
            }
        } catch (SQLException e) {
            System.err.println("Error while creating student.");
            e.printStackTrace(); // exception only in catch block as requested
        }
    }

    public Student getStudentById(int id) {
        String sql = "SELECT * FROM student WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Student s = new Student();
                    s.setStudentId(rs.getInt("student_id"));
                    s.setRollNo(rs.getString("roll_no"));
                    s.setFullName(rs.getString("full_name"));
                    s.setEmail(rs.getString("email"));
                    s.setBranch(rs.getString("branch"));
                    s.setYear(rs.getInt("year"));
                    s.setStatus(rs.getString("status"));
                    return s;
                } else {
                    System.out.println("Student not found with id: " + id);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching student by id.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Student> getAllStudents() {
        List<Student> list = new ArrayList<>();
        String sql = "SELECT * FROM student ORDER BY student_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            while (rs.next()) {
                Student s = new Student();
                s.setStudentId(rs.getInt("student_id"));
                s.setRollNo(rs.getString("roll_no"));
                s.setFullName(rs.getString("full_name"));
                s.setEmail(rs.getString("email"));
                s.setBranch(rs.getString("branch"));
                s.setYear(rs.getInt("year"));
                s.setStatus(rs.getString("status"));
                list.add(s);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching students list.");
            e.printStackTrace();
        }
        return list;
    }

    public void updateStudent(Student s) {
        String sql = "UPDATE student SET roll_no = ?, full_name = ?, email = ?, branch = ?, year = ?, status = ? WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, s.getRollNo());
            ps.setString(2, s.getFullName());
            ps.setString(3, s.getEmail());
            ps.setString(4, s.getBranch());
            ps.setInt(5, s.getYear());
            ps.setString(6, s.getStatus());
            ps.setInt(7, s.getStudentId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student updated successfully (id: " + s.getStudentId() + ").");
            } else {
                System.out.println("Update failed or no changes made for student id: " + s.getStudentId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating student.");
            e.printStackTrace();
        }
    }

    public void deleteStudent(int id) {
        String sql = "DELETE FROM student WHERE student_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Student deleted successfully (id: " + id + ").");
            } else {
                System.out.println("No student found to delete with id: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting student.");
            e.printStackTrace();
        }
    }
}

