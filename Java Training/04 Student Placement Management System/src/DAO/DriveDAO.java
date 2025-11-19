package DAO;

import Models.Drive;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DriveDAO {

    public void createDrive(Drive d) {
        String sql = "INSERT INTO drive (title, company_id, scheduled_date, admin_id) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, d.getTitle());
            ps.setInt(2, d.getCompanyId());
            ps.setDate(3, d.getScheduledDate());
            if (d.getAdminId() != null) ps.setInt(4, d.getAdminId());
            else ps.setNull(4, Types.INTEGER);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) d.setDriveId(rs.getInt(1));
                }
                System.out.println("Drive created with id: " + d.getDriveId());
            } else {
                System.out.println("Drive creation failed.");
            }
        } catch (SQLException e) {
            System.err.println("Error creating drive.");
            e.printStackTrace();
        }
    }

    public Drive getDriveById(int id) {
        String sql = "SELECT * FROM drive WHERE drive_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Drive d = new Drive();
                    d.setDriveId(rs.getInt("drive_id"));
                    d.setTitle(rs.getString("title"));
                    d.setCompanyId(rs.getInt("company_id"));
                    d.setScheduledDate(rs.getDate("scheduled_date"));
                    int adminId = rs.getInt("admin_id");
                    if (rs.wasNull()) d.setAdminId(null);
                    else d.setAdminId(adminId);
                    return d;
                } else {
                    System.out.println("Drive not found id: " + id);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching drive.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Drive> getAllDrives() {
        List<Drive> list = new ArrayList<>();
        String sql = "SELECT * FROM drive ORDER BY drive_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Drive d = new Drive();
                d.setDriveId(rs.getInt("drive_id"));
                d.setTitle(rs.getString("title"));
                d.setCompanyId(rs.getInt("company_id"));
                d.setScheduledDate(rs.getDate("scheduled_date"));
                int aid = rs.getInt("admin_id");
                if (rs.wasNull()) d.setAdminId(null);
                else d.setAdminId(aid);
                list.add(d);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching drives.");
            e.printStackTrace();
        }
        return list;
    }

    public void updateDrive(Drive d) {
        String sql = "UPDATE drive SET title = ?, company_id = ?, scheduled_date = ?, admin_id = ? WHERE drive_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getTitle());
            ps.setInt(2, d.getCompanyId());
            ps.setDate(3, d.getScheduledDate());
            if (d.getAdminId() != null) ps.setInt(4, d.getAdminId());
            else ps.setNull(4, Types.INTEGER);
            ps.setInt(5, d.getDriveId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Drive updated id: " + d.getDriveId());
            } else {
                System.out.println("No drive updated for id: " + d.getDriveId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating drive.");
            e.printStackTrace();
        }
    }

    public void deleteDrive(int id) {
        String sql = "DELETE FROM drive WHERE drive_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Drive deleted: " + id);
            } else {
                System.out.println("No drive found with id: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting drive.");
            e.printStackTrace();
        }
    }
}
