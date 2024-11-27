package equipment;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EquipmentManager {

    public void addEquipment(Equipment equipment) {
        String sql = "INSERT INTO Equipment (equipment_id, inventory_id, type, description, dimensions, weight, asset_id) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, equipment.getEquipmentID());
            pstmt.setString(2, equipment.getInventoryID());
            pstmt.setString(3, equipment.getType());
            pstmt.setString(4, equipment.getDescription());
            pstmt.setString(5, equipment.getDimensions());
            pstmt.setDouble(6, equipment.getWeight());
            pstmt.setString(7, equipment.getAssetID());

            pstmt.executeUpdate();
            System.out.println("Equipment added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding equipment: " + e.getMessage());
        }
    }

    public void editEquipment(String equipmentID, Equipment equipment) {
        String sql = "UPDATE Equipment SET inventory_id = ?, type = ?, description = ?, "
                + "dimensions = ?, weight = ?, asset_id = ? WHERE equipment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, equipment.getInventoryID());
            pstmt.setString(2, equipment.getType());
            pstmt.setString(3, equipment.getDescription());
            pstmt.setString(4, equipment.getDimensions());
            pstmt.setDouble(5, equipment.getWeight());
            pstmt.setString(6, equipment.getAssetID());
            pstmt.setString(7, equipmentID);

            int result = pstmt.executeUpdate();
            if (result > 0) {
                System.out.println("Equipment updated successfully!");
            } else {
                System.out.println("Equipment not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating equipment: " + e.getMessage());
        }
    }

    public void deleteEquipment(String equipmentID) {
        String sql = "DELETE FROM Equipment WHERE equipment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, equipmentID);
            int result = pstmt.executeUpdate();

            if (result > 0) {
                System.out.println("Equipment deleted successfully!");
            } else {
                System.out.println("Equipment not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting equipment: " + e.getMessage());
        }
    }

    public Equipment searchEquipment(String equipmentID) {
        String sql = "SELECT * FROM Equipment WHERE equipment_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, equipmentID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Equipment(
                    rs.getString("equipment_id"),
                    rs.getString("inventory_id"),
                    rs.getString("type"),
                    rs.getString("description"),
                    rs.getString("dimensions"),
                    rs.getDouble("weight"),
                    rs.getString("asset_id")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error searching equipment: " + e.getMessage());
        }
        return null;
    }

    public List<Equipment> listAllEquipment() {
        List<Equipment> equipmentList = new ArrayList<>();
        String sql = "SELECT * FROM Equipment";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Equipment equipment = new Equipment(
                    rs.getString("equipment_id"),
                    rs.getString("inventory_id"),
                    rs.getString("type"),
                    rs.getString("description"),
                    rs.getString("dimensions"),
                    rs.getDouble("weight"),
                    rs.getString("asset_id")
                );
                equipmentList.add(equipment);
            }

        } catch (SQLException e) {
            System.out.println("Error listing equipment: " + e.getMessage());
        }
        return equipmentList;
    }
}