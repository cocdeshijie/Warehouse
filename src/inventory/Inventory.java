package inventory;

public class Inventory {
    private String inventoryID;
    private String name;
    private int availableDrones;
    private int availableEquipment;

    public Inventory(String inventoryID, String name, int availableDrones, int availableEquipment) {
        this.inventoryID = inventoryID;
        this.name = name;
        this.availableDrones = availableDrones;
        this.availableEquipment = availableEquipment;
    }

    // Getters and Setters
    public String getInventoryID() { return inventoryID; }
    public void setInventoryID(String inventoryID) { this.inventoryID = inventoryID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getAvailableDrones() { return availableDrones; }
    public void setAvailableDrones(int availableDrones) { this.availableDrones = availableDrones; }

    public int getAvailableEquipment() { return availableEquipment; }
    public void setAvailableEquipment(int availableEquipment) { this.availableEquipment = availableEquipment; }
}
