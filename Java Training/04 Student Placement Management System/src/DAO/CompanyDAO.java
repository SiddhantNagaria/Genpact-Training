package DAO;

import Models.Company;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CompanyDAO {

    public void createCompany(Company c) {
        String sql = "INSERT INTO company (name, website, contact_email) VALUES (?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, c.getName());
            ps.setString(2, c.getWebsite());
            ps.setString(3, c.getContactEmail());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                try (ResultSet rs = ps.getGeneratedKeys()) {
                    if (rs.next()) c.setCompanyId(rs.getInt(1));
                }
                System.out.println("Company created with id: " + c.getCompanyId());
            } else {
                System.out.println("Failed to create company.");
            }
        } catch (SQLException e) {
            System.err.println("Error creating company.");
            e.printStackTrace();
        }
    }

    public Company getCompanyById(int id) {
        String sql = "SELECT * FROM company WHERE company_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Company c = new Company();
                    c.setCompanyId(rs.getInt("company_id"));
                    c.setName(rs.getString("name"));
                    c.setWebsite(rs.getString("website"));
                    c.setContactEmail(rs.getString("contact_email"));
                    return c;
                } else {
                    System.out.println("Company not found id: " + id);
                    return null;
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching company.");
            e.printStackTrace();
            return null;
        }
    }

    public List<Company> getAllCompanies() {
        List<Company> list = new ArrayList<>();
        String sql = "SELECT * FROM company ORDER BY company_id";
        try (Connection conn = DBConnection.getConnection();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Company c = new Company();
                c.setCompanyId(rs.getInt("company_id"));
                c.setName(rs.getString("name"));
                c.setWebsite(rs.getString("website"));
                c.setContactEmail(rs.getString("contact_email"));
                list.add(c);
            }
        } catch (SQLException e) {
            System.err.println("Error fetching companies.");
            e.printStackTrace();
        }
        return list;
    }

    public void updateCompany(Company c) {
        String sql = "UPDATE company SET name = ?, website = ?, contact_email = ? WHERE company_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, c.getName());
            ps.setString(2, c.getWebsite());
            ps.setString(3, c.getContactEmail());
            ps.setInt(4, c.getCompanyId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Company updated: " + c.getCompanyId());
            } else {
                System.out.println("No company updated for id: " + c.getCompanyId());
            }
        } catch (SQLException e) {
            System.err.println("Error updating company.");
            e.printStackTrace();
        }
    }

    public void deleteCompany(int id) {
        String sql = "DELETE FROM company WHERE company_id = ?";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            if (rows > 0) {
                System.out.println("Company deleted id: " + id);
            } else {
                System.out.println("No company found with id: " + id);
            }
        } catch (SQLException e) {
            System.err.println("Error deleting company.");
            e.printStackTrace();
        }
    }
}
