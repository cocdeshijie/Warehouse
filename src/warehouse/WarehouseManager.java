package warehouse;

import java.util.ArrayList;
import java.util.Scanner;

public class WarehouseManager {
    private ArrayList<Warehouse> warehouses;

    public WarehouseManager() {
        warehouses = new ArrayList<>();
    }

    // Add new warehouse
    public void addWarehouse(Warehouse warehouse) {
        warehouses.add(warehouse);
        System.out.println("Warehouse added successfully!");
    }

    // Edit existing warehouse
    public void editWarehouse(String warehouseID, Scanner scanner) {
        Warehouse existingWarehouse = searchWarehouse(warehouseID);
        if (existingWarehouse != null) {
            System.out.println("Enter New Warehouse Details:");
            System.out.print("Storage Capacity: ");
            String newStorageCapacity = scanner.nextLine();
            System.out.print("City: ");
            String newCity = scanner.nextLine();
            System.out.print("Address: ");
            String newAddress = scanner.nextLine();
            System.out.print("Phone: ");
            String newPhone = scanner.nextLine();
            System.out.print("Manager Name: ");
            String newManagerName = scanner.nextLine();
            System.out.print("Drone Capacity: ");
            int newDroneCapacity = Integer.parseInt(scanner.nextLine());

            existingWarehouse.setStorageCapacity(newStorageCapacity);
            existingWarehouse.setCity(newCity);
            existingWarehouse.setAddress(newAddress);
            existingWarehouse.setPhone(newPhone);
            existingWarehouse.setManagerName(newManagerName);
            existingWarehouse.setDroneCapacity(newDroneCapacity);

            System.out.println("Warehouse with ID " + warehouseID + " has been updated.");
        } else {
            System.out.println("Warehouse with ID " + warehouseID + " not found.");
        }
    }

    // Delete warehouse
    public void deleteWarehouse(String warehouseID) {
        Warehouse warehouse = searchWarehouse(warehouseID);
        if (warehouse != null) {
            warehouses.remove(warehouse);
            System.out.println("Warehouse with ID " + warehouseID + " has been deleted.");
        } else {
            System.out.println("Warehouse with ID " + warehouseID + " not found.");
        }
    }

    // Search warehouse
    public Warehouse searchWarehouse(String warehouseID) {
        for (Warehouse warehouse : warehouses) {
            if (warehouse.getWarehouseID().equals(warehouseID)) {
                return warehouse;
            }
        }
        return null;
    }

    // List all warehouses
    public void listAllWarehouses() {
        if (warehouses.isEmpty()) {
            System.out.println("No warehouses available.");
        } else {
            for (Warehouse warehouse : warehouses) {
                System.out.println(warehouse.toString());
            }
        }
    }
}
