package com.galvanize.cart;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CartTest {

    @Test
    public void cartIsEmptyForNewUser() {
        //setup
        Cart testCart = new Cart();
        int expected = 0;
        //execute
        int actual = testCart.getCart().size();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTotalPriceForTheFirstItem() {
        //setup
        Cart testCart = new Cart();
        Item testItem = new Item("banana", 2.99);
        testCart.addItem(testItem);
        double expected = 2.99;
        //execute
        double actual = testCart.getTotalPrice();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getTotalPriceForMultipleItems() {
        //setup
        Cart testCart = new Cart();
        Item testItem = new Item("banana", 2.99);
        testCart.addItem(testItem);
        testCart.addItem(testItem);
        double expected = 5.98;
        //execute
        double actual = testCart.getTotalPrice();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getItemizedListAfterAddingItems() {
        //setup
        Cart testCart = new Cart();
        Item testItem1 = new Item("banana", 2.99);
        testCart.addItem(testItem1);
        Item testItem2 = new Item("apple", 3.99);
        testCart.addItem(testItem2);
        Item testItem3 = new Item("orange", 4.99);
        testCart.addItem(testItem3);
        String expected = "banana: 2.99, apple: 3.99, orange: 4.99";
        //execute
        String actual = testCart.itemizedList();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getItemQuantitiesFromEmptyCart() {
        //setup
        Cart testCart = new Cart();
        int expected = 0;
        //execute
        int actual = testCart.itemQuantities();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getItemQuantitiesFromCart() {
        //setup
        Cart testCart = new Cart(); 
        Item testItem1 = new Item("banana", 2.99);
        testCart.addItem(testItem1);
        Item testItem2 = new Item("apple", 1.99);
        testCart.addItem(testItem2);
        int expected = 2;
        //execute
        int actual = testCart.itemQuantities();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getOnSaleItemsWhenNoItemsOnSale() {
        //setup
        Cart testCart = new Cart();
        Item testItem1 = new Item("banana", 2.99);
        testCart.addItem(testItem1);
        Item testItem2 = new Item("apple", 1.99);
        testCart.addItem(testItem2);
        ArrayList<Item> expected = new ArrayList<Item>();
        //execute
        ArrayList<Item> actual = testCart.onSaleItems();
        //assert
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
