package warehouse;

public class Warehouse {
    private String warehouseID;
    private String storageCapacity;
    private String city;
    private String address;
    private String phone;
    private String managerName;
    private int droneCapacity;

    public Warehouse(String warehouseID, String storageCapacity, String city, String address, String phone, String managerName, int droneCapacity) {
        this.warehouseID = warehouseID;
        this.storageCapacity = storageCapacity;
        this.city = city;
        this.address = address;
        this.phone = phone;
        this.managerName = managerName;
        this.droneCapacity = droneCapacity;
    }

    // Getters and Setters
    public String getWarehouseID() { return warehouseID; }
    public void setWarehouseID(String warehouseID) { this.warehouseID = warehouseID; }

    public String getStorageCapacity() { return storageCapacity; }
    public void setStorageCapacity(String storageCapacity) { this.storageCapacity = storageCapacity; }

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

    // toString method
    @Override
    public String toString() {
        return "Warehouse ID: " + warehouseID + ", City: " + city + ", Manager: " + managerName;
    }
}
