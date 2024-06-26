
package Model;


import java.util.Date;

public class ModelOrders {
    private int orderID;
    private int customerID;
    private double totalAmount;

    public ModelOrders(int orderID, int customerID, double totalAmount) {
        this.orderID = orderID;
        this.customerID = customerID;
        this.totalAmount = totalAmount;
    }

    public ModelOrders() {
    }

    // Getter and setter methods for the fields
    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Override
    public String toString() {
        return "ModelOrders{" +
                "orderID=" + orderID +
                ", customerID=" + customerID +
                ", totalAmount=" + totalAmount +
                '}';
    }
}

