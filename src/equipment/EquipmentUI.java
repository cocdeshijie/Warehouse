package equipment;

import java.util.Scanner;

public class EquipmentUI {
    private final EquipmentManager equipmentManager;
    private final Scanner scanner;

    public EquipmentUI(EquipmentManager equipmentManager, Scanner scanner) {
        this.equipmentManager = equipmentManager;
        this.scanner = scanner;
    }

    public void equipmentMenu() {
        boolean exit = false;
        while (!exit) {
            System.out.println("===== Equipment Menu =====");
            System.out.println("1. Add New Equipment");
            System.out.println("2. Edit Equipment");
            System.out.println("3. Delete Equipment");
            System.out.println("4. Search Equipment");
            System.out.println("5. List All Equipment");
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
                case 1: addNewEquipment(); break;
                case 2: editEquipment(); break;
                case 3: deleteEquipment(); break;
                case 4: searchEquipment(); break;
                case 5: listAllEquipment(); break;
                case 6: exit = true; break;
                default: System.out.println("Invalid option.");
            }
            System.out.println();
        }
    }

    private void addNewEquipment() {
        System.out.println("Enter Equipment Details:");
        System.out.print("Equipment ID: ");
        String equipmentID = scanner.nextLine();
        System.out.print("Inventory ID: ");
        String inventoryID = scanner.nextLine();
        System.out.print("Type: ");
        String type = scanner.nextLine();
        System.out.print("Description: ");
        String description = scanner.nextLine();
        System.out.print("Dimensions: ");
        String dimensions = scanner.nextLine();
        System.out.print("Weight: ");
        double weight;
        try {
            weight = Double.parseDouble(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Invalid weight.");
            return;
        }
        System.out.print("Asset ID: ");
        String assetID = scanner.nextLine();

        Equipment equipment = new Equipment(equipmentID, inventoryID, type, description, dimensions, weight, assetID);
        equipmentManager.addEquipment(equipment);
    }

    private void editEquipment() {
        System.out.print("Enter Equipment ID to edit: ");
        String equipmentID = scanner.nextLine();

        Equipment existingEquipment = equipmentManager.searchEquipment(equipmentID);
        if (existingEquipment != null) {
            System.out.println("Enter New Equipment Details:");
            System.out.print("Inventory ID: ");
            String newInventoryID = scanner.nextLine();
            System.out.print("Type: ");
            String newType = scanner.nextLine();
            System.out.print("Description: ");
            String newDescription = scanner.nextLine();
            System.out.print("Dimensions: ");
            String newDimensions = scanner.nextLine();
            System.out.print("Weight: ");
            double newWeight;
            try {
                newWeight = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid weight.");
                return;
            }
            System.out.print("Asset ID: ");
            String newAssetID = scanner.nextLine();

            Equipment updatedEquipment = new Equipment(equipmentID, newInventoryID, newType, newDescription,
                                                     newDimensions, newWeight, newAssetID);
            equipmentManager.editEquipment(equipmentID, updatedEquipment);
        } else {
            System.out.println("Equipment not found.");
        }
    }

    private void deleteEquipment() {
        System.out.print("Enter Equipment ID to delete: ");
        String equipmentID = scanner.nextLine();
        equipmentManager.deleteEquipment(equipmentID);
    }

    private void searchEquipment() {
        System.out.print("Enter Equipment ID to search: ");
        String equipmentID = scanner.nextLine();
        Equipment equipment = equipmentManager.searchEquipment(equipmentID);
        if (equipment != null) {
            System.out.println(equipment.toString());
        } else {
            System.out.println("Equipment not found.");
        }
    }

    private void listAllEquipment() {
        equipmentManager.listAllEquipment().forEach(System.out::println);
    }
}