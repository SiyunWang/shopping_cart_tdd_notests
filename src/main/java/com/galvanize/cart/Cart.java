package com.galvanize.cart;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> cart = new ArrayList<Item>();

    public Cart() {

    }

    public ArrayList<Item> getCart() {
        return cart;
    }

    public void addItem(Item newItem) {
        cart.add(newItem);
    }

    public double getTotalPrice() {
        double total = 0;
        for (Item item: cart) {
            total += item.getPrice();
        }
        return total;
    }
}
