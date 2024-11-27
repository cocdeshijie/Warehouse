package customer;

import java.util.Scanner;
import java.util.Date;

public class CustomerUI {
    private final CustomerManager customerManager;
    private final Scanner scanner;

    public CustomerUI(CustomerManager customerManager, Scanner scanner) {
        this.customerManager = customerManager;
        this.scanner = scanner;
    }

    public void customerMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Customer Menu =====");
            System.out.println("1. Add New Customer");
            System.out.println("2. Edit Customer");
            System.out.println("3. Delete Customer");
            System.out.println("4. Search Customer");
            System.out.println("5. List All Customers");
            System.out.println("6. Back to Main Menu");
            System.out.print("Please choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1: addNewCustomer(); break;
                case 2: editCustomer(); break;
                case 3: deleteCustomer(); break;
                case 4: searchCustomer(); break;
                case 5: listAllCustomers(); break;
                case 6: exit = true; break;
                default: System.out.println("Invalid option.");
            }
            System.out.println();
        }
    }

    private void addNewCustomer() {
        System.out.println("Enter Customer Details:");
        System.out.print("User ID: ");
        String userID = scanner.nextLine();
        System.out.print("First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Address: ");
        String address = scanner.nextLine();
        System.out.print("Phone: ");
        String phone = scanner.nextLine();
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Warehouse Distance: ");
        double warehouseDistance;
        try {
            warehouseDistance = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid warehouse distance.");
            return;
        }
        System.out.print("Is Active (true/false): ");
        boolean isActive;
        try {
            isActive = Boolean.parseBoolean(scanner.nextLine());
        } catch (Exception e) {
            System.out.println("Invalid input for isActive.");
            return;
        }
        Date startDate = new Date();

        Customer customer = new Customer(userID, firstName, lastName, address, phone, email,
                                      warehouseDistance, isActive, startDate);
        customerManager.addCustomer(customer);
    }

    private void editCustomer() {
        System.out.print("Enter Customer ID to edit: ");
        String userID = scanner.nextLine();
        customerManager.editCustomer(userID, scanner);
    }

    private void deleteCustomer() {
        System.out.print("Enter Customer ID to delete: ");
        String userID = scanner.nextLine();
        customerManager.deleteCustomer(userID);
    }

    private void searchCustomer() {
        System.out.print("Enter Customer ID to search: ");
        String userID = scanner.nextLine();
        Customer customer = customerManager.searchCustomer(userID);
        if (customer != null) {
            System.out.println(customer.toString());
        } else {
            System.out.println("Customer not found.");
        }
    }

    private void listAllCustomers() {
        customerManager.listAllCustomers();
    }
}