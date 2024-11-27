package rental;

import java.util.Date;

public class Rental {
    private String rentalID;
    private Date dueDate;
    private Date returnDate;
    private Date checkOutDate;
    private double fees;
    private String pickupID;
    private String dropoffID;
    private String memberID;
    private String equipmentID;
    private String droneID;
    private String deliveryLogID;

    public Rental(String rentalID, Date dueDate, Date returnDate, Date checkOutDate,
                 double fees, String pickupID, String dropoffID, String memberID,
                 String equipmentID, String droneID, String deliveryLogID) {
        this.rentalID = rentalID;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.checkOutDate = checkOutDate;
        this.fees = fees;
        this.pickupID = pickupID;
        this.dropoffID = dropoffID;
        this.memberID = memberID;
        this.equipmentID = equipmentID;
        this.droneID = droneID;
        this.deliveryLogID = deliveryLogID;
    }

    // Getters and Setters
    public String getRentalID() { return rentalID; }
    public void setRentalID(String rentalID) { this.rentalID = rentalID; }

    public Date getDueDate() { return dueDate; }
    public void setDueDate(Date dueDate) { this.dueDate = dueDate; }

    public Date getReturnDate() { return returnDate; }
    public void setReturnDate(Date returnDate) { this.returnDate = returnDate; }

    public Date getCheckOutDate() { return checkOutDate; }
    public void setCheckOutDate(Date checkOutDate) { this.checkOutDate = checkOutDate; }

    public double getFees() { return fees; }
    public void setFees(double fees) { this.fees = fees; }

    public String getPickupID() { return pickupID; }
    public void setPickupID(String pickupID) { this.pickupID = pickupID; }

    public String getDropoffID() { return dropoffID; }
    public void setDropoffID(String dropoffID) { this.dropoffID = dropoffID; }

    public String getMemberID() { return memberID; }
    public void setMemberID(String memberID) { this.memberID = memberID; }

    public String getEquipmentID() { return equipmentID; }
    public void setEquipmentID(String equipmentID) { this.equipmentID = equipmentID; }

    public String getDroneID() { return droneID; }
    public void setDroneID(String droneID) { this.droneID = droneID; }

    public String getDeliveryLogID() { return deliveryLogID; }
    public void setDeliveryLogID(String deliveryLogID) { this.deliveryLogID = deliveryLogID; }
}