package customer;

import java.util.Date;

public class Customer {
    private String userID;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String email;
    private double warehouseDistance;
    private boolean isActive;
    private Date startDate;

    public Customer(String userID, String firstName, String lastName, String address, String phone, String email, double warehouseDistance, boolean isActive, Date startDate) {
        this.userID = userID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.warehouseDistance = warehouseDistance;
        this.isActive = isActive;
        this.startDate = startDate;
    }

    // Getters and Setters
    public String getUserID() { return userID; }
    public void setUserID(String userID) { this.userID = userID; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getAddress() { return address; }
    public void setAddress(String address) { this.address = address; }

    public String getPhone() { return phone; }
    public void setPhone(String phone) { this.phone = phone; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public double getWarehouseDistance() { return warehouseDistance; }
    public void setWarehouseDistance(double warehouseDistance) { this.warehouseDistance = warehouseDistance; }

    public boolean isActive() { return isActive; }
    public void setActive(boolean active) { isActive = active; }

    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }

    // toString method
    @Override
    public String toString() {
        return "Customer ID: " + userID + ", Name: " + firstName + " " + lastName;
    }
}
