package warehouse;

import java.util.Scanner;

public class WarehouseUI {
    private final WarehouseManager warehouseManager;
    private final Scanner scanner;

    public WarehouseUI(WarehouseManager warehouseManager, Scanner scanner) {
        this.warehouseManager = warehouseManager;
        this.scanner = scanner;
    }

    public void warehouseMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Warehouse Menu =====");
            System.out.println("1. Add New Warehouse");
            System.out.println("2. Edit Warehouse");
            System.out.println("3. Delete Warehouse");
            System.out.println("4. Search Warehouse");
            System.out.println("5. List All Warehouses");
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
                case 1: addNewWarehouse(); break;
                case 2: editWarehouse(); break;
                case 3: deleteWarehouse(); break;
                case 4: searchWarehouse(); break;
                case 5: listAllWarehouses(); break;
                case 6: exit = true; break;
                default: System.out.println("Invalid option.");
            }
            System.out.println();
        }
    }

    private void addNewWarehouse() {
        System.out.println("Enter Warehouse Details:");
        System.out.print("Warehouse ID: ");
        String warehouseID = scanner.nextLine();
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

        Warehouse warehouse = new Warehouse(warehouseID, name, storageCapacity, city,
                                         address, phone, managerName, droneCapacity,
                                         availableDrones, availableEquipment);
        warehouseManager.addWarehouse(warehouse);
    }

    private void editWarehouse() {
        System.out.print("Enter Warehouse ID to edit: ");
        String warehouseID = scanner.nextLine();
        warehouseManager.editWarehouse(warehouseID, scanner);
    }

    private void deleteWarehouse() {
        System.out.print("Enter Warehouse ID to delete: ");
        String warehouseID = scanner.nextLine();
        warehouseManager.deleteWarehouse(warehouseID);
    }

    private void searchWarehouse() {
        System.out.print("Enter Warehouse ID to search: ");
        String warehouseID = scanner.nextLine();
        Warehouse warehouse = warehouseManager.searchWarehouse(warehouseID);
        if (warehouse != null) {
            System.out.println(warehouse.toString());
        } else {
            System.out.println("Warehouse not found.");
        }
    }

    private void listAllWarehouses() {
        warehouseManager.listAllWarehouses();
    }
}