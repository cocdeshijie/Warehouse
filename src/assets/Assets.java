package assets;

import java.util.Date;

public class Assets {
    private String assetID;
    private String status;
    private String location;
    private boolean active;
    private int year;
    private String model;
    private String serialNo;
    private String manufacturer;
    private Date warrantyExp;
    private String warehouseID;

    public Assets(String assetID, String status, String location, boolean active,
                int year, String model, String serialNo, String manufacturer,
                Date warrantyExp, String warehouseID) {
        this.assetID = assetID;
        this.status = status;
        this.location = location;
        this.active = active;
        this.year = year;
        this.model = model;
        this.serialNo = serialNo;
        this.manufacturer = manufacturer;
        this.warrantyExp = warrantyExp;
        this.warehouseID = warehouseID;
    }

    // Getters and Setters
    public String getAssetID() { return assetID; }
    public void setAssetID(String assetID) { this.assetID = assetID; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getModel() { return model; }
    public void setModel(String model) { this.model = model; }

    public String getSerialNo() { return serialNo; }
    public void setSerialNo(String serialNo) { this.serialNo = serialNo; }

    public String getManufacturer() { return manufacturer; }
    public void setManufacturer(String manufacturer) { this.manufacturer = manufacturer; }

    public Date getWarrantyExp() { return warrantyExp; }
    public void setWarrantyExp(Date warrantyExp) { this.warrantyExp = warrantyExp; }

    public String getWarehouseID() { return warehouseID; }
    public void setWarehouseID(String warehouseID) { this.warehouseID = warehouseID; }
}