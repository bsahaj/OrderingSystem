package com.sahajb.orderingsystem;

public class OrderInfo {
    private String customerName;
    private int breakfast;
    private int entree;
    private int dessert;
    private int orderNumber;

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(int breakfast) {
        this.breakfast = breakfast;
    }

    public int getEntree() {
        return entree;
    }

    public void setEntree(int entree) {
        this.entree = entree;
    }

    public int getDessert() {
        return dessert;
    }

    public void setDessert(int dessert) {
        this.dessert = dessert;
    }

    public String getCustomerName() {
        return customerName;

    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double totalCost() { //for calculating the total cost.
        String total;
        double t;
        total = String.format("%.2f", (5.99*getBreakfast()) + (9.99*getEntree()) + (11.99*getDessert()));
        t = Double.valueOf(total);
        return t;
    }
}
