package equipment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class EquipmentManager {
    private ArrayList<Equipment> equipments;
    private Map<String, String> equipmentRentals; // Map EquipmentID to UserID

    public EquipmentManager() {
        equipments = new ArrayList<>();
        equipmentRentals = new HashMap<>();
    }

    // Add new equipment
    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
        System.out.println("Equipment added successfully!");
    }

    // Edit existing equipment
    public void editEquipment(String equipmentID, Equipment updatedEquipment) {
        for (int i = 0; i < equipments.size(); i++) {
            if (equipments.get(i).getEquipmentID().equals(equipmentID)) {
                equipments.set(i, updatedEquipment);
                System.out.println("Equipment with ID " + equipmentID + " has been updated.");
                return;
            }
        }
        System.out.println("Equipment with ID " + equipmentID + " not found.");
    }

    // Delete equipment
    public void deleteEquipment(String equipmentID) {
        for (int i = 0; i < equipments.size(); i++) {
            if (equipments.get(i).getEquipmentID().equals(equipmentID)) {
                equipments.remove(i);
                System.out.println("Equipment with ID " + equipmentID + " has been deleted.");
                return;
            }
        }
        System.out.println("Equipment with ID " + equipmentID + " not found.");
    }

    // Search equipment
    public Equipment searchEquipment(String equipmentID) {
        for (Equipment equipment : equipments) {
            if (equipment.getEquipmentID().equals(equipmentID)) {
                return equipment;
            }
        }
        return null;
    }

    // List all equipment
    public void listAllEquipments() {
        if (equipments.isEmpty()) {
            System.out.println("No equipment available.");
        } else {
            for (Equipment equipment : equipments) {
                System.out.println(equipment.toString());
            }
        }
    }

    // Rent equipment
    public void rentEquipment(String equipmentID, String userID) {
        Equipment equipment = searchEquipment(equipmentID);
        if (equipment != null) {
            if (!equipmentRentals.containsKey(equipmentID)) {
                equipmentRentals.put(equipmentID, userID);
                System.out.println("Equipment with ID " + equipmentID + " has been rented to User ID " + userID);
            } else {
                System.out.println("Equipment with ID " + equipmentID + " is already rented.");
            }
        } else {
            System.out.println("Equipment with ID " + equipmentID + " not found.");
        }
    }

    // Return equipment
    public void returnEquipment(String equipmentID) {
        if (equipmentRentals.containsKey(equipmentID)) {
            equipmentRentals.remove(equipmentID);
            System.out.println("Equipment with ID " + equipmentID + " has been returned.");
        } else {
            System.out.println("Equipment with ID " + equipmentID + " is not currently rented.");
        }
    }

    // Check if equipment is rented
    public boolean isEquipmentRented(String equipmentID) {
        return equipmentRentals.containsKey(equipmentID);
    }

    // Get renter of equipment
    public String getEquipmentRenter(String equipmentID) {
        return equipmentRentals.get(equipmentID);
    }

    // Delivery of equipment (Placeholder)
    public void scheduleDelivery(String equipmentID, String userID, String droneID) {
        // Since drone functionality is not implemented, we'll just print a message
        System.out.println("Scheduled delivery of equipment ID " + equipmentID + " using Drone ID " + droneID + " to user ID " + userID);
    }

    // Pickup of equipment (Placeholder)
    public void schedulePickup(String equipmentID, String userID, String droneID) {
        // Since drone functionality is not implemented, we'll just print a message
        System.out.println("Scheduled pickup of equipment ID " + equipmentID + " using Drone ID " + droneID + " from user ID " + userID);
    }
}
