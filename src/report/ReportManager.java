package report;

import utils.DatabaseConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReportManager {

    public ReportManager() {
    }

    // Report 1: Renting Checkouts
    public void getTotalRentalsByMember(String memberId) {
        String sql = "SELECT COUNT(*) AS total_items_rented "
                + "FROM Rental "
                + "WHERE member_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, memberId);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                int totalItemsRented = rs.getInt("total_items_rented");
                System.out.println("Total number of equipment items rented by member ID " + memberId + ": " + totalItemsRented);
            } else {
                System.out.println("No rentals found for member ID " + memberId);
            }

        } catch (SQLException e) {
            System.out.println("Error executing report: " + e.getMessage());
        }
    }

    // Report 2: Popular Item
    public void getMostPopularItem() {
        String sql = "SELECT E.equipment_id, E.type, E.description, COUNT(R.rental_id) AS times_rented "
                + "FROM Rental R "
                + "JOIN Equipment E ON R.equipment_id = E.equipment_id "
                + "GROUP BY E.equipment_id, E.type, E.description "
                + "ORDER BY times_rented DESC "
                + "LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String equipmentId = rs.getString("equipment_id");
                String type = rs.getString("type");
                String description = rs.getString("description");
                int timesRented = rs.getInt("times_rented");

                System.out.println("Most Popular Item:");
                System.out.println("Equipment ID: " + equipmentId);
                System.out.println("Type: " + type);
                System.out.println("Description: " + description);
                System.out.println("Times Rented: " + timesRented);
            } else {
                System.out.println("No rental records found.");
            }

        } catch (SQLException e) {
            System.out.println("Error executing report: " + e.getMessage());
        }
    }

    // Report 3: Popular Manufacturer
    public void getMostFrequentManufacturer() {
        String sql = "SELECT A.manufacturer, COUNT(R.rental_id) AS total_rentals "
                + "FROM Rental R "
                + "JOIN Equipment E ON R.equipment_id = E.equipment_id "
                + "JOIN Assets A ON E.asset_id = A.asset_id "
                + "GROUP BY A.manufacturer "
                + "ORDER BY total_rentals DESC "
                + "LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String manufacturer = rs.getString("manufacturer");
                int totalRentals = rs.getInt("total_rentals");

                System.out.println("Most Frequent Equipment Manufacturer:");
                System.out.println("Manufacturer: " + manufacturer);
                System.out.println("Total Rentals: " + totalRentals);
            } else {
                System.out.println("No rental records found.");
            }

        } catch (SQLException e) {
            System.out.println("Error executing report: " + e.getMessage());
        }
    }

    // Report 4: Popular Drone
    public void getMostUsedDrone() {
        String sql = "SELECT drone_id, COUNT(*) AS delivery_count, SUM(distance_traveled) AS total_distance "
                + "FROM Delivery_Log "
                + "GROUP BY drone_id "
                + "ORDER BY delivery_count DESC, total_distance DESC "
                + "LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String droneId = rs.getString("drone_id");
                int deliveryCount = rs.getInt("delivery_count");
                double totalDistance = rs.getDouble("total_distance");

                System.out.println("Most Used Drone:");
                System.out.println("Drone ID: " + droneId);
                System.out.println("Number of Deliveries: " + deliveryCount);
                System.out.println("Total Distance Traveled: " + totalDistance);
            } else {
                System.out.println("No delivery records found.");
            }

        } catch (SQLException e) {
            System.out.println("Error executing report: " + e.getMessage());
        }
    }

    // Report 5: Items Checked Out
    public void getMemberWithMostRentals() {
        String sql = "SELECT R.member_id, C.fname, C.lname, COUNT(*) AS total_items_rented "
                + "FROM Rental R "
                + "JOIN Customer C ON R.member_id = C.user_id "
                + "GROUP BY R.member_id, C.fname, C.lname "
                + "ORDER BY total_items_rented DESC "
                + "LIMIT 1";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String memberId = rs.getString("member_id");
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                int totalItemsRented = rs.getInt("total_items_rented");

                System.out.println("Member with Most Items Checked Out:");
                System.out.println("Member ID: " + memberId);
                System.out.println("Name: " + firstName + " " + lastName);
                System.out.println("Total Items Rented: " + totalItemsRented);
            } else {
                System.out.println("No rental records found.");
            }

        } catch (SQLException e) {
            System.out.println("Error executing report: " + e.getMessage());
        }
    }

    // Report 6: Equipment by Type Released Before Year
    public void getEquipmentByTypeBeforeYear(String type, int year) {
        String sql = "SELECT E.description, E.type, A.year "
                + "FROM Equipment E "
                + "JOIN Assets A ON E.asset_id = A.asset_id "
                + "WHERE E.type = ? AND A.year < ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, type);
            pstmt.setInt(2, year);
            ResultSet rs = pstmt.executeQuery();

            boolean hasResults = false;
            while (rs.next()) {
                hasResults = true;
                String description = rs.getString("description");
                int equipmentYear = rs.getInt("year");

                System.out.println("Description: " + description + ", Year: " + equipmentYear);
            }

            if (!hasResults) {
                System.out.println("No equipment found for type '" + type + "' released before " + year);
            }

        } catch (SQLException e) {
            System.out.println("Error executing report: " + e.getMessage());
        }
    }
}
