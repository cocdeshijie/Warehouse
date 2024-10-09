package order;

import java.util.Date;

public class Order {
    private String orderNo;
    private String element;
    private int quantity;
    private double value;
    private Date estimatedArrival;
    private Date actualArrival;

    public Order(String orderNo, String element, int quantity, double value, Date estimatedArrival, Date actualArrival) {
        this.orderNo = orderNo;
        this.element = element;
        this.quantity = quantity;
        this.value = value;
        this.estimatedArrival = estimatedArrival;
        this.actualArrival = actualArrival;
    }

    // Getters and Setters
    public String getOrderNo() { return orderNo; }
    public void setOrderNo(String orderNo) { this.orderNo = orderNo; }

    public String getElement() { return element; }
    public void setElement(String element) { this.element = element; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getValue() { return value; }
    public void setValue(double value) { this.value = value; }

    public Date getEstimatedArrival() { return estimatedArrival; }
    public void setEstimatedArrival(Date estimatedArrival) { this.estimatedArrival = estimatedArrival; }

    public Date getActualArrival() { return actualArrival; }
    public void setActualArrival(Date actualArrival) { this.actualArrival = actualArrival; }
}
