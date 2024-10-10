package edu.uw.tcss.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

public class CartTest {
    /**
     * name for test item
     */
    private static final String ITEM_NAME = "Apple";
    /**
     * single price for all test items
     */
    private static final String ITEM_PRICE = "2.00";
    /**
     * quantity for test order
     */
    private static final int ORDER_QUANTITY = 12;
    /**
     * test StoreItem object
     */
    private static final StoreItem TEST_ITEM = new StoreItem(ITEM_NAME,new BigDecimal(ITEM_PRICE));
    /**
     * test StoreItemOrder object
     */
    private static final StoreItemOrder TEST_ITEM_ORDER = new StoreItemOrder(TEST_ITEM, ORDER_QUANTITY);

    private static final StoreCart TEST_CART = new StoreCart();

    @Test
    void testAdd() {

    }

    @Test
    void testSetMembership() {
        /*
        for this one i need to add an item order to the cart, set membership, and check the
        total to see if it lines up with a manually calculated whatever.
        i don't know how to run all that shit inside the assertAll(), so i'll have to ask
        i could try adding an item to the cart before all these test i guess???
        i think it would work, it just feels wrong
        assertAll("test setMembership()",
                () -> assertTrue(TEST_CART.setMembership(true))
                );*/
    }

    @Test
    void testClear() {

    }

    @Test
    void testGetCartSize() {

    }

    @Test
    void testToString() {

    }

    @Test
    void testCalculateTotal() {

    }
}
