package equipment;

import java.util.Scanner;

public class EquipmentUI {
    private EquipmentManager equipmentManager;
    private Scanner scanner;

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
            System.out.println("6. Rent Equipment");
            System.out.println("7. Return Equipment");
            System.out.println("8. Schedule Delivery");
            System.out.println("9. Schedule Pickup");
            System.out.println("10. Back to Main Menu");
            System.out.print("Please choose an option: ");
            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewEquipment();
                    break;
                case 2:
                    editEquipment();
                    break;
                case 3:
                    deleteEquipment();
                    break;
                case 4:
                    searchEquipment();
                    break;
                case 5:
                    listAllEquipments();
                    break;
                case 6:
                    rentEquipment();
                    break;
                case 7:
                    returnEquipment();
                    break;
                case 8:
                    scheduleDelivery();
                    break;
                case 9:
                    schedulePickup();
                    break;
                case 10:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
            System.out.println();
        }
    }

    private void addNewEquipment() {
        System.out.println("Enter Equipment Details:");
        System.out.print("Equipment ID: ");
        String equipmentID = scanner.nextLine();
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

        Equipment equipment = new Equipment(equipmentID, type, description, dimensions, weight);
        equipmentManager.addEquipment(equipment);
    }

    private void editEquipment() {
        System.out.print("Enter Equipment ID to edit: ");
        String equipmentID = scanner.nextLine();
        Equipment existingEquipment = equipmentManager.searchEquipment(equipmentID);
        if (existingEquipment != null) {
            System.out.println("Enter New Equipment Details:");
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

            Equipment updatedEquipment = new Equipment(equipmentID, newType, newDescription, newDimensions, newWeight);
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
            System.out.println("Equipment found: " + equipment.toString());
        } else {
            System.out.println("Equipment not found.");
        }
    }

    private void listAllEquipments() {
        equipmentManager.listAllEquipments();
    }

    private void rentEquipment() {
        System.out.print("Enter Equipment ID to rent: ");
        String equipmentID = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();
        equipmentManager.rentEquipment(equipmentID, userID);
    }

    private void returnEquipment() {
        System.out.print("Enter Equipment ID to return: ");
        String equipmentID = scanner.nextLine();
        equipmentManager.returnEquipment(equipmentID);
    }

    private void scheduleDelivery() {
        System.out.print("Enter Equipment ID to deliver: ");
        String equipmentID = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter Drone ID: ");
        String droneID = scanner.nextLine();
        equipmentManager.scheduleDelivery(equipmentID, userID, droneID);
    }

    private void schedulePickup() {
        System.out.print("Enter Equipment ID to pick up: ");
        String equipmentID = scanner.nextLine();
        System.out.print("Enter User ID: ");
        String userID = scanner.nextLine();
        System.out.print("Enter Drone ID: ");
        String droneID = scanner.nextLine();
        equipmentManager.schedulePickup(equipmentID, userID, droneID);
    }
}
