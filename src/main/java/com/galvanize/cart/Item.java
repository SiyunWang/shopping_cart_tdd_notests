package com.galvanize.cart;

public class Item {
    private String name;
    private double price;
    private boolean onSale = false;

    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean getOnSale() {
        return this.onSale;
    } 
    
    public void toggleSale() {
        this.onSale = !this.onSale;
    }
}
