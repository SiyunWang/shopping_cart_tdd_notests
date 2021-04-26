package com.galvanize.cart;

import org.checkerframework.checker.units.qual.C;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ItemTest {
  @Test
  public void itemDefaultNotOnSale() {
    //setup
    Item testItem = new Item("apple", 1.99);
    boolean expected = false;
    //execute
    boolean actual = testItem.getOnSale();
    //assert
    assertEquals(expected, actual);
  }

  @Test
  public void toggleSaleMethod() {
    //setup
    Item testItem = new Item("apple", 1.99);
    boolean expected = true;
    //execute
    testItem.toggleSale();
    boolean actual = testItem.getOnSale();
    //assert
    assertEquals(expected, actual);
  }
}
