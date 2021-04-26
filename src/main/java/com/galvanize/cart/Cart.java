package com.galvanize.cart;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

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

    public String itemizedList() {
        String itemsList = "";
        for (int i = 0; i < cart.size(); i++) {
            Item item = cart.get(i);
            if (i == cart.size() - 1) {
                itemsList += item.getName() + ": " + item.getPrice();
            } else {
                itemsList += item.getName() + ": " + item.getPrice() + ", ";
            }
        }
        return itemsList;
    }

    public String itemQuantities() {
        String quantities = "";
        LinkedHashMap<Item, Integer> itemCounts = new LinkedHashMap<>();
        for (Item item: cart) {
            if (itemCounts.containsKey(item)) {
                itemCounts.put(item, itemCounts.get(item) + 1);
            } else {
                itemCounts.put(item, 1);
            }
        }

        for (Item item: itemCounts.keySet()) {
            quantities += item.getName() + ": " + itemCounts.get(item) + ", ";
        }
        if (!quantities.equals("")) {
            return quantities.substring(0, quantities.length() - 2);
        }
        return quantities;
    }

    public ArrayList<Item> onSaleItems() {
        ArrayList<Item> saleItems = new ArrayList<Item>();

        for (Item item : cart) {
            if (item.getOnSale()) {
                saleItems.add(item);
            }
        }

        return saleItems;
    }
}
