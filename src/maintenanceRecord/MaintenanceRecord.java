package maintenanceRecord;

import java.util.Date;

public class MaintenanceRecord {
    private String maintenanceID;
    private String equipmentID;
    private String droneID;
    private String maintenanceDetails;
    private Date maintenanceDate;

    public MaintenanceRecord(String maintenanceID, String equipmentID, String droneID, String maintenanceDetails, Date maintenanceDate) {
        this.maintenanceID = maintenanceID;
        this.equipmentID = equipmentID;
        this.droneID = droneID;
        this.maintenanceDetails = maintenanceDetails;
        this.maintenanceDate = maintenanceDate;
    }

    // Getters and Setters
    public String getMaintenanceID() { return maintenanceID; }
    public void setMaintenanceID(String maintenanceID) { this.maintenanceID = maintenanceID; }

    public String getEquipmentID() { return equipmentID; }
    public void setEquipmentID(String equipmentID) { this.equipmentID = equipmentID; }

    public String getDroneID() { return droneID; }
    public void setDroneID(String droneID) { this.droneID = droneID; }

    public String getMaintenanceDetails() { return maintenanceDetails; }
    public void setMaintenanceDetails(String maintenanceDetails) { this.maintenanceDetails = maintenanceDetails; }

    public Date getMaintenanceDate() { return maintenanceDate; }
    public void setMaintenanceDate(Date maintenanceDate) { this.maintenanceDate = maintenanceDate; }
}
