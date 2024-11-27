package customer;

import utils.DatabaseConnection;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;
import java.util.Date;

public class CustomerManager {

    public CustomerManager() {
    }

    // Add new customer
    public void addCustomer(Customer customer) {
        String sql = "INSERT INTO Customer("
                + "user_id, first_name, last_name, address, phone, email, "
                + "warehouse_distance, is_active, start_date"
                + ") VALUES(?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, customer.getUserID());
            pstmt.setString(2, customer.getFirstName());
            pstmt.setString(3, customer.getLastName());
            pstmt.setString(4, customer.getAddress());
            pstmt.setString(5, customer.getPhone());
            pstmt.setString(6, customer.getEmail());
            pstmt.setDouble(7, customer.getWarehouseDistance());
            pstmt.setBoolean(8, customer.isActive());
            pstmt.setDate(9, new java.sql.Date(customer.getStartDate().getTime()));

            pstmt.executeUpdate();
            System.out.println("Customer added successfully!");

        } catch (SQLException e) {
            System.out.println("Error adding customer: " + e.getMessage());
        }
    }

    // Edit existing customer
    public void editCustomer(String userID, Scanner scanner) {
        String sql = "UPDATE Customer SET "
                + "first_name = ?, last_name = ?, address = ?, phone = ?, email = ?, "
                + "warehouse_distance = ?, is_active = ? "
                + "WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            System.out.println("Enter New Customer Details:");
            System.out.print("First Name: ");
            String newFirstName = scanner.nextLine();
            System.out.print("Last Name: ");
            String newLastName = scanner.nextLine();
            System.out.print("Address: ");
            String newAddress = scanner.nextLine();
            System.out.print("Phone: ");
            String newPhone = scanner.nextLine();
            System.out.print("Email: ");
            String newEmail = scanner.nextLine();
            System.out.print("Warehouse Distance: ");
            double newWarehouseDistance = Double.parseDouble(scanner.nextLine());
            System.out.print("Is Active (true/false): ");
            boolean newIsActive = Boolean.parseBoolean(scanner.nextLine());

            pstmt.setString(1, newFirstName);
            pstmt.setString(2, newLastName);
            pstmt.setString(3, newAddress);
            pstmt.setString(4, newPhone);
            pstmt.setString(5, newEmail);
            pstmt.setDouble(6, newWarehouseDistance);
            pstmt.setBoolean(7, newIsActive);
            pstmt.setString(8, userID);

            int affectedRows = pstmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Customer with ID " + userID + " has been updated.");
            } else {
                System.out.println("Customer with ID " + userID + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error editing customer: " + e.getMessage());
        }
    }

    // Delete customer
    public void deleteCustomer(String userID) {
        String sql = "DELETE FROM Customer WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userID);
            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("Customer with ID " + userID + " has been deleted.");
            } else {
                System.out.println("Customer with ID " + userID + " not found.");
            }

        } catch (SQLException e) {
            System.out.println("Error deleting customer: " + e.getMessage());
        }
    }

    // Search customer
    public Customer searchCustomer(String userID) {
        String sql = "SELECT * FROM Customer WHERE user_id = ?";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, userID);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                // Retrieve and parse the date
                String startDateStr = rs.getString("start_date");
                Date startDate = null;
                if (startDateStr != null) {
                    try {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                        startDate = sdf.parse(startDateStr);
                    } catch (ParseException e) {
                        System.out.println("Error parsing start date: " + e.getMessage());
                    }
                }

                // Create Customer object
                String userId = rs.getString("user_id");
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                String address = rs.getString("address");
                String phone = rs.getString("phone");
                String email = rs.getString("email");
                double warehouseDistance = rs.getDouble("warehouse_distance");
                boolean isActive = rs.getBoolean("is_active");

                Customer customer = new Customer(userId, firstName, lastName, address, phone, email,
                        warehouseDistance, isActive, startDate);
                return customer;

            } else {
                return null;
            }

        } catch (SQLException e) {
            System.out.println("Error searching customer: " + e.getMessage());
            return null;
        }
    }

    // List all customers
    public void listAllCustomers() {
        String sql = "SELECT * FROM Customer";

        try (Connection conn = DatabaseConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            boolean hasData = false;
            while (rs.next()) {
                hasData = true;
                String userId = rs.getString("user_id");
                String firstName = rs.getString("fname");
                String lastName = rs.getString("lname");
                System.out.println("Customer ID: " + userId + ", Name: " + firstName + " " + lastName);
            }
            if (!hasData) {
                System.out.println("No customers available.");
            }

        } catch (SQLException e) {
            System.out.println("Error listing customers: " + e.getMessage());
        }
    }
}
