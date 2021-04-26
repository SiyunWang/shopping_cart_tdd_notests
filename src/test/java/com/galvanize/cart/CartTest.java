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
        double expected = 2.99;
        //execute
        testCart.addItem(testItem);
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

    //test itemizedList with only one item first
    //test name should allow you to understand it out of context

    @Test
    public void getItemizedListAfterAddingItems() { //givenMultipleItemsItemizedListReturnsItemList
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


    //looking for string with Bananas: 3, etc
    @Test
    public void getItemQuantitiesFromEmptyCart() {
        //setup
        Cart testCart = new Cart();
        String expected = "";
        //execute
        String actual = testCart.itemQuantities();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getItemQuantitiesFromCart() {
        //setup
        Cart testCart = new Cart();
        Item testItem1 = new Item("banana", 2.99);
        Item testItem2 = new Item("apple", 1.99);
        String expected = "banana: 1, apple: 1";
        //execute
        testCart.addItem(testItem1);
        testCart.addItem(testItem2);
        String actual = testCart.itemQuantities();
        //assert
        assertEquals(expected, actual);
    }

    @Test
    public void getItemQuantitiesFromCartWithDuplicatedItems() {
        //setup
        Cart testCart = new Cart();
        Item testItem1 = new Item("banana", 2.99);
        String expected = "banana: 2";
        //execute
        testCart.addItem(testItem1);
        testCart.addItem(testItem1);
        String actual = testCart.itemQuantities();
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

    @Test
    public void getOnSaleItemsAfterSaleItemsAdded() {
        //setup
        Cart testCart = new Cart();
        Item testItem1 = new Item("banana", 2.99);
        testCart.addItem(testItem1);
        Item testItem2 = new Item("apple", 1.99);
        testCart.addItem(testItem2);
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(testItem1);
        //execute
        testItem1.toggleSale();
        ArrayList<Item> actual = testCart.onSaleItems();
        //assert
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void getMultipleOnSaleItemsAfterSaleItemsAdded() {
        //setup
        Cart testCart = new Cart();
        Item testItem1 = new Item("banana", 2.99);
        testCart.addItem(testItem1);
        Item testItem2 = new Item("apple", 1.99);
        testCart.addItem(testItem2);
        ArrayList<Item> expected = new ArrayList<Item>();
        expected.add(testItem1);
        expected.add(testItem2);
        //execute
        testItem1.toggleSale();
        testItem2.toggleSale();
        ArrayList<Item> actual = testCart.onSaleItems();
        //assert
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

    @Test
    public void toggleSaleStatusOfItem() {
        //setup
        Cart testCart = new Cart();
        Item testItem1 = new Item("banana", 2.99);
        testCart.addItem(testItem1);
        ArrayList<Item> expected = new ArrayList<Item>();
        //execute
        testItem1.toggleSale();
        testItem1.toggleSale();
        ArrayList<Item> actual = testCart.onSaleItems();
        //assert
        assertArrayEquals(expected.toArray(), actual.toArray());
    }

}
