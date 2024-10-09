package rental;

import java.util.Date;

public class Rental {
    private String rentalID;
    private Date dueDate;
    private Date returnDate;
    private Date checkOutDate;
    private double fees;

    public Rental(String rentalID, Date dueDate, Date returnDate, Date checkOutDate, double fees) {
        this.rentalID = rentalID;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.checkOutDate = checkOutDate;
        this.fees = fees;
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
}
