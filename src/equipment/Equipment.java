package equipment;

public class Equipment {
    private String equipmentID;
    private String inventoryID;
    private String type;
    private String description;
    private String dimensions;
    private double weight;
    private String assetID;

    public Equipment(String equipmentID, String inventoryID, String type, String description,
                    String dimensions, double weight, String assetID) {
        this.equipmentID = equipmentID;
        this.inventoryID = inventoryID;
        this.type = type;
        this.description = description;
        this.dimensions = dimensions;
        this.weight = weight;
        this.assetID = assetID;
    }

    // Getters and Setters
    public String getEquipmentID() { return equipmentID; }
    public void setEquipmentID(String equipmentID) { this.equipmentID = equipmentID; }

    public String getInventoryID() { return inventoryID; }
    public void setInventoryID(String inventoryID) { this.inventoryID = inventoryID; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    public String getAssetID() { return assetID; }
    public void setAssetID(String assetID) { this.assetID = assetID; }

    @Override
    public String toString() {
        return "Equipment ID: " + equipmentID + ", Type: " + type + ", Description: " + description;
    }
}