package deliveryLog;

import java.util.Date;

public class DeliveryLog {
    private String deliveryLogID;
    private String droneID;
    private String orderID;
    private Date deliveryDate;
    private String deliveryStatus;
    private double distanceTraveled;
    private double deliveryTime;

    public DeliveryLog(String deliveryLogID, String droneID, String orderID, Date deliveryDate, String deliveryStatus, double distanceTraveled, double deliveryTime) {
        this.deliveryLogID = deliveryLogID;
        this.droneID = droneID;
        this.orderID = orderID;
        this.deliveryDate = deliveryDate;
        this.deliveryStatus = deliveryStatus;
        this.distanceTraveled = distanceTraveled;
        this.deliveryTime = deliveryTime;
    }

    // Getters and Setters
    public String getDeliveryLogID() { return deliveryLogID; }
    public void setDeliveryLogID(String deliveryLogID) { this.deliveryLogID = deliveryLogID; }

    public String getDroneID() { return droneID; }
    public void setDroneID(String droneID) { this.droneID = droneID; }

    public String getOrderID() { return orderID; }
    public void setOrderID(String orderID) { this.orderID = orderID; }

    public Date getDeliveryDate() { return deliveryDate; }
    public void setDeliveryDate(Date deliveryDate) { this.deliveryDate = deliveryDate; }

    public String getDeliveryStatus() { return deliveryStatus; }
    public void setDeliveryStatus(String deliveryStatus) { this.deliveryStatus = deliveryStatus; }

    public double getDistanceTraveled() { return distanceTraveled; }
    public void setDistanceTraveled(double distanceTraveled) { this.distanceTraveled = distanceTraveled; }

    public double getDeliveryTime() { return deliveryTime; }
    public void setDeliveryTime(double deliveryTime) { this.deliveryTime = deliveryTime; }
}
