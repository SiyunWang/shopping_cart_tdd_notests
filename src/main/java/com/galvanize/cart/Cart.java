package com.galvanize.cart;

import java.util.ArrayList;

public class Cart {
    private ArrayList<Item> cart = new ArrayList<Item>();

    public Cart() {

    }

    public ArrayList<Item> getCart() {
        return cart;
    }
}
