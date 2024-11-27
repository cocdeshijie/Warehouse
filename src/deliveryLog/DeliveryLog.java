package deliveryLog;

import java.util.Date;

public class DeliveryLog {
    private String deliveryLogID;
    private Date deliveryDate;
    private String deliveryStatus;
    private double distanceTraveled;
    private String deliveryTime;
    private String droneID;
    private String equipmentID;

    public DeliveryLog(String deliveryLogID, Date deliveryDate, String deliveryStatus,
                      double distanceTraveled, String deliveryTime, String droneID, String equipmentID) {
        this.deliveryLogID = deliveryLogID;
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.distanceTraveled = distanceTraveled;
        this.deliveryTime = deliveryTime;
        this.droneID = droneID;
        this.equipmentID = equipmentID;
    }

    // Getters and Setters
    public String getDeliveryLogID() { return deliveryLogID; }
    public void setDeliveryLogID(String deliveryLogID) { this.deliveryLogID = deliveryLogID; }

    public Date getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }

    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    public double getDistanceTraveled() { return distanceTraveled; }
    public void setDistanceTraveled(double distanceTraveled) { this.distanceTraveled = distanceTraveled; }

    public String getDeliveryTime() { return deliveryTime; }
    public void setDeliveryTime(String deliveryTime) { this.deliveryTime = deliveryTime; }

    public String getDroneID() { return droneID; }
    public void setDroneID(String droneID) { this.droneID = droneID; }

    public String getEquipmentID() { return equipmentID; }
    public void setEquipmentID(String equipmentID) { this.equipmentID = equipmentID; }
}