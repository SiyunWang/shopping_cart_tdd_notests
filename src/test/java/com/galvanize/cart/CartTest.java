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


}
