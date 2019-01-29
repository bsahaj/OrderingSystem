package com.sahajb.orderingsystem;

public class Product {
   // private int id;
    private String name;
    private String breakfast;
    private String entree;
    private String dessert;


    public Product( String name, String breakfast, String entree, String dessert) {
        this.name = name;
        this.breakfast = breakfast;
        this.entree = entree;
        this.dessert = dessert;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBreakfast() {
        return breakfast;
    }

    public void setBreakfast(String breakfast) {
        this.breakfast = breakfast;
    }

    public String getEntree() {
        return entree;
    }

    public void setEntree(String entree) {
        this.entree = entree;
    }

    public String getDessert() {
        return dessert;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }
}