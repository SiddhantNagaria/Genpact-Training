package DAO;

import Models.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    public void createAdmin(Admin a) {
        String sql = "INSERT INTO admin (username, password, full_name, email) VALUES (?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getFullName());
            ps.setString(4, a.getEmail());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) a.setAdminId(rs.getInt(1));
                }
                System.out.println("Admin created id: " + a.getAdminId());
            } else {
                System.out.println("Failed to create admin.");
            }
        } catch (SQLException e) {
            System.err.println("Error creating admin.");
            e.printStackTrace();
        }
    }

    public Admin getAdminById(int id) {
        String sql = "SELECT * FROM admin WHERE admin_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Admin a = new Admin();
                    a.setAdminId(rs.getInt("admin_id"));
                    a.setUsername(rs.getString("username"));
                    a.setPassword(rs.getString("password"));
                    a.setFullName(rs.getString("full_name"));
                    a.setEmail(rs.getString("email"));
                    return a;
                } else {
                    System.out.println("Admin not found id: " + id);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching admin.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Admin> getAllAdmins() {
        List<Admin> list = new ArrayList<>();
        String sql = "SELECT * FROM admin ORDER BY admin_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Admin a = new Admin();
                a.setAdminId(rs.getInt("admin_id"));
                a.setUsername(rs.getString("username"));
                a.setPassword(rs.getString("password"));
                a.setFullName(rs.getString("full_name"));
                a.setEmail(rs.getString("email"));
                list.add(a);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching admins.");
            e.printStackTrace();
        }
        return list;
    }

    public void updateAdmin(Admin a) {
        String sql = "UPDATE admin SET username = ?, password = ?, full_name = ?, email = ? WHERE admin_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getUsername());
            ps.setString(2, a.getPassword());
            ps.setString(3, a.getFullName());
            ps.setString(4, a.getEmail());
            ps.setInt(5, a.getAdminId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Admin updated id: " + a.getAdminId());
            } else {
                System.out.println("No admin updated for id: " + a.getAdminId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating admin.");
            e.printStackTrace();
        }
    }

    public void deleteAdmin(int id) {
        String sql = "DELETE FROM admin WHERE admin_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Admin deleted id: " + id);
            } else {
                System.out.println("No admin found with id: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting admin.");
            e.printStackTrace();
        }
    }
}

