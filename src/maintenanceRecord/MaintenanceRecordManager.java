package maintenanceRecord;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MaintenanceRecordManager {

    public void addMaintenanceRecord(MaintenanceRecord record) {
        String sql = "INSERT INTO Maintenance_Record (maintenance_id, maintenance_date, maintenance_details, " +
                    "equipment_id, drone_id, warehouse_id) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, record.getMaintenanceID());
            pstmt.setDate(2, new java.sql.Date(record.getMaintenanceDate().getTime()));
            pstmt.setString(3, record.getMaintenanceDetails());
            pstmt.setString(4, record.getEquipmentID());
            pstmt.setString(5, record.getDroneID());

            pstmt.executeUpdate();
            System.out.println("Maintenance record added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding maintenance record: " + e.getMessage());
        }
    }

    public void updateMaintenanceRecord(MaintenanceRecord record) {
        String sql = "UPDATE Maintenance_Record SET maintenance_date = ?, maintenance_details = ?, " +
                    "equipment_id = ?, drone_id = ?, warehouse_id = ? WHERE maintenance_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setDate(1, new java.sql.Date(record.getMaintenanceDate().getTime()));
            pstmt.setString(2, record.getMaintenanceDetails());
            pstmt.setString(3, record.getEquipmentID());
            pstmt.setString(4, record.getDroneID());
            pstmt.setString(6, record.getMaintenanceID());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Maintenance record updated successfully!");
            } else {
                System.out.println("Maintenance record not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating maintenance record: " + e.getMessage());
        }
    }

    public void deleteMaintenanceRecord(String maintenanceID) {
        String sql = "DELETE FROM Maintenance_Record WHERE maintenance_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maintenanceID);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("Maintenance record deleted successfully!");
            } else {
                System.out.println("Maintenance record not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting maintenance record: " + e.getMessage());
        }
    }

    public MaintenanceRecord getMaintenanceRecord(String maintenanceID) {
        String sql = "SELECT * FROM Maintenance_Record WHERE maintenance_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, maintenanceID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new MaintenanceRecord(
                    rs.getString("maintenance_id"),
                    rs.getString("equipment_id"),
                    rs.getString("drone_id"),
                    rs.getString("maintenance_details"),
                    rs.getDate("maintenance_date")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving maintenance record: " + e.getMessage());
        }
        return null;
    }

    public List<MaintenanceRecord> getAllMaintenanceRecords() {
        List<MaintenanceRecord> records = new ArrayList<>();
        String sql = "SELECT * FROM Maintenance_Record";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                records.add(new MaintenanceRecord(
                    rs.getString("maintenance_id"),
                    rs.getString("equipment_id"),
                    rs.getString("drone_id"),
                    rs.getString("maintenance_details"),
                    rs.getDate("maintenance_date")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error retrieving maintenance records: " + e.getMessage());
        }
        return records;
    }
}