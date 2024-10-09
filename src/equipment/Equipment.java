package equipment;

public class Equipment {
    private String equipmentID;
    private String type;
    private String description;
    private String dimensions;
    private double weight;

    public Equipment(String equipmentID, String type, String description, String dimensions, double weight) {
        this.equipmentID = equipmentID;
        this.type = type;
        this.description = description;
        this.dimensions = dimensions;
        this.weight = weight;
    }

    // Getters and Setters
    public String getEquipmentID() { return equipmentID; }
    public void setEquipmentID(String equipmentID) { this.equipmentID = equipmentID; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getDimensions() { return dimensions; }
    public void setDimensions(String dimensions) { this.dimensions = dimensions; }

    public double getWeight() { return weight; }
    public void setWeight(double weight) { this.weight = weight; }

    // toString method
    @Override
    public String toString() {
        return "Equipment ID: " + equipmentID + ", Type: " + type + ", Description: " + description;
    }
}
