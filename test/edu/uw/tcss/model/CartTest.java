package edu.uw.tcss.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CartTest {
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
    /**
     * test StoreCart object to be created for each test
     */
    //I know there's a CheckStyle warning here, it thinks TEST_CART is an
    //instance variable because of the way JUnit @BeforeEach works.
    //To me it doesn't make sense to rename the variable, but let me know
    //if I'm wrong.
    @SuppressWarnings("checkstyle:MemberName")
    private StoreCart TEST_CART;
    @BeforeEach
    void testSetup() {
        TEST_CART = new StoreCart();
    }

    @Test
    void testGetCartSize() {
        assertAll("testing getCartSize() at base case",
            () -> assertEquals(0, TEST_CART.getCartSize().itemOrderCount(),
                    "Cart does not have 0 item orders by default."),
            () -> assertEquals(0, TEST_CART.getCartSize().itemCount(),
                    "Cart does not have 0 items by default.")
        );
        TEST_CART.add(new StoreItemOrder(TEST_ITEM, 0));
        assertAll("testing getCartSize() adding 0 quantity item",
                () -> assertEquals(0, TEST_CART.getCartSize().itemOrderCount(),
                        "Cart does not handle 0 quantity correctly."),
                () -> assertEquals(0, TEST_CART.getCartSize().itemCount(),
                        "Cart does not handle 0 quantity correctly.")
        );
        TEST_CART.add(TEST_ITEM_ORDER);
        assertAll("testing getCartSize() with items",
            () -> assertEquals(1, TEST_CART.getCartSize().itemOrderCount(),
                        "Cart does not get itemOrderCount correctly."),
            () -> assertEquals(ORDER_QUANTITY, TEST_CART.getCartSize().itemCount(),
                        "Cart does not get itemCount correctly.")
        );
    }

    @Test
    void testAdd() {
        TEST_CART.add(TEST_ITEM_ORDER);
        assertAll("testing add()",
                () -> assertEquals(1, TEST_CART.getCartSize().itemOrderCount(),
                        "Cart does not add itemOrderCount correctly."),
                () -> assertEquals(ORDER_QUANTITY, TEST_CART.getCartSize().itemCount(),
                        "Cart does not add itemCount correctly.")
        );
    }

    @Test
    void testSetMembership() {
        TEST_CART.add(TEST_BULK_ITEM_ORDER);
        assertEquals(new BigDecimal("24.00"), TEST_CART.calculateTotal(),
                "Membership default state is incorrect.");
        TEST_CART.setMembership(true);
        assertEquals(new BigDecimal("19.00"), TEST_CART.calculateTotal(),
                "Membership true state is incorrect.");
    }

    @Test
    void testClear() {
        TEST_CART.add(TEST_ITEM_ORDER);
        TEST_CART.clear();
        assertEquals(0, TEST_CART.getCartSize().itemCount(),
                "Cart does not clear correctly.");
    }

    @Test
    void testToString() {
        assertEquals("0 item orders 0 items. []", TEST_CART.toString(),
                "Returned string of an empty cart does not match.");
        TEST_CART.add(TEST_ITEM_ORDER);
        assertEquals("1 item orders 12 items. [(Apple, $2.00)]", TEST_CART.toString(),
                "Returned string of full cart does not match.");
        //might wanna add the total price to the toString() as well for debugging or whatever
    }

    @Test
    void testCalculateTotal() {
        TEST_CART.add(TEST_ITEM_ORDER);
        assertEquals(new BigDecimal("24.00"), TEST_CART.calculateTotal(),
                "Single item order has the wrong total.");
        TEST_CART.add(TEST_BULK_ITEM_ORDER);
        TEST_CART.setMembership(true);
        assertEquals(new BigDecimal("43.00"), TEST_CART.calculateTotal(),
                "Bulk item order has the wrong total.");
    }
}
