package com.galvanize.cart;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

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
}
