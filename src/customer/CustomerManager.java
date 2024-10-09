package customer;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Date;

public class CustomerManager {
    private ArrayList<Customer> customers;

    public CustomerManager() {
        customers = new ArrayList<>();
    }

    // Add new customer
    public void addCustomer(Customer customer) {
        customers.add(customer);
        System.out.println("Customer added successfully!");
    }

    // Edit existing customer
    public void editCustomer(String userID, Scanner scanner) {
        Customer existingCustomer = searchCustomer(userID);
        if (existingCustomer != null) {
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

            existingCustomer.setFirstName(newFirstName);
            existingCustomer.setLastName(newLastName);
            existingCustomer.setAddress(newAddress);
            existingCustomer.setPhone(newPhone);
            existingCustomer.setEmail(newEmail);
            existingCustomer.setWarehouseDistance(newWarehouseDistance);
            existingCustomer.setActive(newIsActive);

            System.out.println("Customer with ID " + userID + " has been updated.");
        } else {
            System.out.println("Customer with ID " + userID + " not found.");
        }
    }

    // Delete customer
    public void deleteCustomer(String userID) {
        Customer customer = searchCustomer(userID);
        if (customer != null) {
            customers.remove(customer);
            System.out.println("Customer with ID " + userID + " has been deleted.");
        } else {
            System.out.println("Customer with ID " + userID + " not found.");
        }
    }

    // Search customer
    public Customer searchCustomer(String userID) {
        for (Customer customer : customers) {
            if (customer.getUserID().equals(userID)) {
                return customer;
            }
        }
        return null;
    }

    // List all customers
    public void listAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers available.");
        } else {
            for (Customer customer : customers) {
                System.out.println(customer.toString());
            }
        }
    }
}
