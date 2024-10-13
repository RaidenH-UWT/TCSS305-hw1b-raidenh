package edu.uw.tcss.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ItemOrderTest {
    /**
     * name for test item
     */
    private static final String ITEM_NAME = "Apple";
    /**
     * name for test bulk item
     */
    private static final String BULK_ITEM_NAME = "Oranges";
    /**
     * single price for all test items
     */
    private static final String ITEM_PRICE = "2.00";
    /**
     * bulk quantity for test bulk item
     */
    private static final int BULK_QUANTITY = 5;
    /**
     * bulk price for test bulk item
     */
    private static final String BULK_PRICE = "7.50";
    /**
     * quantity for test order
     */
    private static final int ORDER_QUANTITY = 12;
    /**
     * test StoreItem object
     */
    private static final StoreItem TEST_ITEM = new StoreItem(ITEM_NAME,
            new BigDecimal(ITEM_PRICE));
    /**
     * test bulk StoreItem object
     */
    private static final StoreItem TEST_BULK_ITEM = new StoreItem(BULK_ITEM_NAME,
            new BigDecimal(ITEM_PRICE), BULK_QUANTITY, new BigDecimal(BULK_PRICE));
    /**
     * test StoreItemOrder object
     */
    private static final StoreItemOrder TEST_ITEM_ORDER =
            new StoreItemOrder(TEST_ITEM, ORDER_QUANTITY);
    /**
     * test StoreItemOrder object
     */
    private static final StoreItemOrder TEST_BULK_ITEM_ORDER =
            new StoreItemOrder(TEST_BULK_ITEM, ORDER_QUANTITY);

    /* I might not actually need this test cause i'm passing an item
    object to the constructor, not a String name.
    TODO: figure out if testConstructorEmptyItemName is necessary, if not, remove.
    @Test
    void testConstructorEmptyItemName() {
        assertThrows(IllegalArgumentException.class,
                () -> new StoreItemOrder("", ORDER_QUANTITY),
                "Constructor does not handle empty string as item name properly");
    }

    @Test
    void testConstructorNullItemName() {

    }*/

    @Test
    void testConstructorNegativeQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new StoreItemOrder(TEST_ITEM, -1),
                "Constructor does not handle negative quantity correctly.");
    }
    // unsure if this is necessary, zero might be acceptable for ~reasons~ but i'll
    // add it here anyways. remove later if unneeded.
    // TODO: figure out if testConstructorZeroQuantity is necessary, if not, remove.
    @Test
    void testConstructorZeroQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new StoreItemOrder(TEST_ITEM, 0),
                "Constructor does not handle zero quantity correctly.");
    }

    @Test
    void testConstructorNullItem() {
        assertThrows(NullPointerException.class,
                () -> new StoreItemOrder(null, ORDER_QUANTITY),
                "Constructor does not handle null Item correctly.");
    }

    @Test
    void testGetItem() {
        assertEquals(TEST_ITEM,
                TEST_ITEM_ORDER.getItem(),
                "getItem() does not return item object correctly.");
    }

    @Test
    void testGetQuantity() {
        assertEquals(ORDER_QUANTITY,
                TEST_ITEM_ORDER.getQuantity(),
                "getQuantity() does not return ItemOrder quantity correctly.");
    }

    @Test
    void testToString() {
        assertAll("toString test",
                () -> assertEquals("Apple ($2.00), 12",
                        TEST_ITEM_ORDER.toString(),
                        "toString() does not have correct string output for NON-BULK item."),
                () -> assertEquals("Oranges ($2.00, 5 for $7.50), 12",
                        TEST_BULK_ITEM_ORDER.toString(),
                        "toString() does not have correct string output for BULK item.")
        );
    }
}