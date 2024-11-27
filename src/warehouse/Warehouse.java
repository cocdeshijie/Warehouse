package warehouse;

public class Warehouse {
    private String warehouseID;
    private String name;
    private int storageCapacity;
    private String city;
    private String address;
    private String phone;
    private String managerName;
    private int droneCapacity;
    private int availableDrones;
    private int availableEquipment;

    public Warehouse(String warehouseID, String name, int storageCapacity, String city,
                    String address, String phone, String managerName, int droneCapacity,
                    int availableDrones, int availableEquipment) {
        this.warehouseID = warehouseID;
        this.name = name;
        this.storageCapacity = storageCapacity;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.managerName = managerName;
        this.droneCapacity = droneCapacity;
        this.availableDrones = availableDrones;
        this.availableEquipment = availableEquipment;
    }

    // Getters and Setters
    public String getWarehouseID() { return warehouseID; }
    public void setWarehouseID(String warehouseID) { this.warehouseID = warehouseID; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getStorageCapacity() { return storageCapacity; }
    public void setStorageCapacity(int storageCapacity) { this.storageCapacity = storageCapacity; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getManagerName() { return managerName; }
    public void setManagerName(String managerName) { this.managerName = managerName; }

    public int getDroneCapacity() { return droneCapacity; }
    public void setDroneCapacity(int droneCapacity) { this.droneCapacity = droneCapacity; }

    public int getAvailableDrones() { return availableDrones; }
    public void setAvailableDrones(int availableDrones) { this.availableDrones = availableDrones; }

    public int getAvailableEquipment() { return availableEquipment; }
    public void setAvailableEquipment(int availableEquipment) { this.availableEquipment = availableEquipment; }

    @Override
    public String toString() {
        return "Warehouse ID: " + warehouseID + ", Name: " + name + ", City: " + city + ", Manager: " + managerName;
    }
}