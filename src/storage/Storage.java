package storage;

import java.util.Date;

public class Storage {
    private String status;
    private String location;
    private boolean active;
    private int year;
    private String model;
    private String serialNo;
    private String manufacturer;
    private Date warrantyExp;

    public Storage(String status, String location, boolean active, int year, String model, String serialNo, String manufacturer, Date warrantyExp) {
        this.status = status;
        this.location = location;
        this.active = active;
        this.year = year;
        this.model = model;
        this.serialNo = serialNo;
        this.manufacturer = manufacturer;
        this.warrantyExp = warrantyExp;
    }

    // Getters and Setters
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
}
