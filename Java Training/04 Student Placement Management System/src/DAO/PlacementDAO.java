package DAO;
import Models.Placement;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PlacementDAO {

    public void createPlacement(Placement p) {
        String sql = "INSERT INTO placement (student_id, company_id, drive_id, role, status, package_lpa) VALUES (?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1, p.getStudentId());
            ps.setInt(2, p.getCompanyId());
            ps.setInt(3, p.getDriveId());
            ps.setString(4, p.getRole());
            ps.setString(5, p.getStatus());
            if (p.getPackageLpa() != null) ps.setBigDecimal(6, p.getPackageLpa()); else ps.setNull(6, Types.DECIMAL);

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) p.setPlacementId(rs.getInt(1));
                }
                System.out.println("Placement recorded id: " + p.getPlacementId());
            } else {
                System.out.println("Failed to record placement.");
            }
        } catch (SQLException e) {
            System.err.println("Error creating placement.");
            e.printStackTrace();
        }
    }

    public Placement getPlacementById(int id) {
        String sql = "SELECT * FROM placement WHERE placement_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Placement p = new Placement();
                    p.setPlacementId(rs.getInt("placement_id"));
                    p.setStudentId(rs.getInt("student_id"));
                    p.setCompanyId(rs.getInt("company_id"));
                    p.setDriveId(rs.getInt("drive_id"));
                    p.setRole(rs.getString("role"));
                    p.setStatus(rs.getString("status"));
                    p.setPackageLpa(rs.getBigDecimal("package_lpa"));
                    return p;
                } else {
                    System.out.println("Placement not found id: " + id);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching placement.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Placement> getAllPlacements() {
        List<Placement> list = new ArrayList<>();
        String sql = "SELECT * FROM placement ORDER BY placement_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Placement p = new Placement();
                p.setPlacementId(rs.getInt("placement_id"));
                p.setStudentId(rs.getInt("student_id"));
                p.setCompanyId(rs.getInt("company_id"));
                p.setDriveId(rs.getInt("drive_id"));
                p.setRole(rs.getString("role"));
                p.setStatus(rs.getString("status"));
                p.setPackageLpa(rs.getBigDecimal("package_lpa"));
                list.add(p);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching placements.");
            e.printStackTrace();
        }
        return list;
    }

    public void updatePlacement(Placement p) {
        String sql = "UPDATE placement SET student_id = ?, company_id = ?, drive_id = ?, role = ?, status = ?, package_lpa = ? WHERE placement_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, p.getStudentId());
            ps.setInt(2, p.getCompanyId());
            ps.setInt(3, p.getDriveId());
            ps.setString(4, p.getRole());
            ps.setString(5, p.getStatus());
            if (p.getPackageLpa() != null) ps.setBigDecimal(6, p.getPackageLpa()); else ps.setNull(6, Types.DECIMAL);
            ps.setInt(7, p.getPlacementId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Placement updated id: " + p.getPlacementId());
            } else {
                System.out.println("No placement updated for id: " + p.getPlacementId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating placement.");
            e.printStackTrace();
        }
    }

    public void deletePlacement(int id) {
        String sql = "DELETE FROM placement WHERE placement_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Placement deleted id: " + id);
            } else {
                System.out.println("No placement found with id: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting placement.");
            e.printStackTrace();
        }
    }
}

