package warehouse;

import utils.DatabaseConnection;
import java.sql.*;
import java.util.Scanner;

public class WarehouseManager {

    // Add new warehouse
    public void addWarehouse(Warehouse warehouse) {
        String sql = "INSERT INTO Warehouse ("
                + "warehouse_id, name, storage_capacity, city, address, phone, "
                + "mang_name, drone_capacity, available_drones, available_equipment"
                + ") VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, warehouse.getWarehouseID());
            pstmt.setString(2, warehouse.getName());
            pstmt.setInt(3, warehouse.getStorageCapacity());
            pstmt.setString(4, warehouse.getCity());
            pstmt.setString(5, warehouse.getAddress());
            pstmt.setString(6, warehouse.getPhone());
            pstmt.setString(7, warehouse.getManagerName());
            pstmt.setInt(8, warehouse.getDroneCapacity());
            pstmt.setInt(9, warehouse.getAvailableDrones());
            pstmt.setInt(10, warehouse.getAvailableEquipment());

            pstmt.executeUpdate();
            System.out.println("Warehouse added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding warehouse: " + e.getMessage());
        }
    }

    // Edit warehouse
    public void editWarehouse(String warehouseID, Scanner scanner) {
        String sql = "UPDATE Warehouse SET "
                + "name = ?, storage_capacity = ?, city = ?, address = ?, "
                + "phone = ?, mang_name = ?, drone_capacity = ?, "
                + "available_drones = ?, available_equipment = ? "
                + "WHERE warehouse_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            System.out.println("Enter New Warehouse Details:");
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Storage Capacity: ");
            int storageCapacity = Integer.parseInt(scanner.nextLine());
            System.out.print("City: ");
            String city = scanner.nextLine();
            System.out.print("Address: ");
            String address = scanner.nextLine();
            System.out.print("Phone: ");
            String phone = scanner.nextLine();
            System.out.print("Manager Name: ");
            String managerName = scanner.nextLine();
            System.out.print("Drone Capacity: ");
            int droneCapacity = Integer.parseInt(scanner.nextLine());
            System.out.print("Available Drones: ");
            int availableDrones = Integer.parseInt(scanner.nextLine());
            System.out.print("Available Equipment: ");
            int availableEquipment = Integer.parseInt(scanner.nextLine());

            pstmt.setString(1, name);
            pstmt.setInt(2, storageCapacity);
            pstmt.setString(3, city);
            pstmt.setString(4, address);
            pstmt.setString(5, phone);
            pstmt.setString(6, managerName);
            pstmt.setInt(7, droneCapacity);
            pstmt.setInt(8, availableDrones);
            pstmt.setInt(9, availableEquipment);
            pstmt.setString(10, warehouseID);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Warehouse updated successfully!");
            } else {
                System.out.println("Warehouse with ID " + warehouseID + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error updating warehouse: " + e.getMessage());
        }
    }

    // Delete warehouse
    public void deleteWarehouse(String warehouseID) {
        String sql = "DELETE FROM Warehouse WHERE warehouse_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, warehouseID);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Warehouse deleted successfully!");
            } else {
                System.out.println("Warehouse with ID " + warehouseID + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting warehouse: " + e.getMessage());
        }
    }

    // Search warehouse
    public Warehouse searchWarehouse(String warehouseID) {
        String sql = "SELECT * FROM Warehouse WHERE warehouse_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, warehouseID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                return new Warehouse(
                    rs.getString("warehouse_id"),
                    rs.getString("name"),
                    rs.getInt("storage_capacity"),
                    rs.getString("city"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("mang_name"),
                    rs.getInt("drone_capacity"),
                    rs.getInt("available_drones"),
                    rs.getInt("available_equipment")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error searching warehouse: " + e.getMessage());
        }
        return null;
    }

    // List all warehouses
    public void listAllWarehouses() {
        String sql = "SELECT * FROM Warehouse";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Warehouse warehouse = new Warehouse(
                    rs.getString("warehouse_id"),
                    rs.getString("name"),
                    rs.getInt("storage_capacity"),
                    rs.getString("city"),
                    rs.getString("address"),
                    rs.getString("phone"),
                    rs.getString("mang_name"),
                    rs.getInt("drone_capacity"),
                    rs.getInt("available_drones"),
                    rs.getInt("available_equipment")
                );
                System.out.println(warehouse.toString());
            }

        } catch (SQLException e) {
            System.out.println("Error listing warehouses: " + e.getMessage());
        }
    }
}