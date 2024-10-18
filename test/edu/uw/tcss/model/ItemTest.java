package edu.uw.tcss.model;

import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;
import org.junit.jupiter.api.Test;

class ItemTest {
    /**
     * The name of the item used in testing.
     */
    private static final String ITEM_NAME = "Item";

    /**
     * The name of the bulk item used in testing.
     */
    private static final String BULK_ITEM_NAME = "Bulk Item";

    /**
     * The price of the first item used in testing.
     */
    private static final String ITEM_PRICE_ONE = ".50";

    /**
     * The price of the second item used in testing.
     */
    private static final String ITEM_PRICE_TWO = "1.00";

    /**
     * The bulk price of the item used in testing.
     */
    private static final String BULK_PRICE = "4.00";

    /**
     * The negative price of the item used in testing.
     */
    private static final String NEGATIVE_PRICE = "-0.01";

    /**
     * The bulk quantity of the item used in testing.
     */
    private static final int BULK_QUANTITY = 10;

    /**
     * An object of class StoreItem to use in testing.
     */
    private static final StoreItem TEST_ITEM_ONE =
            new StoreItem(ITEM_NAME, new BigDecimal(ITEM_PRICE_ONE));

    /**
     * Another object of class StoreItem to use in testing.
     */
    private static final StoreItem TEST_ITEM_TWO =
            new StoreItem(ITEM_NAME, new BigDecimal(ITEM_PRICE_TWO));

    /**
     * An object of class StoreItem to use in testing.
     */
    private static final StoreItem TEST_BULK_ITEM =
            new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE_ONE),
                    BULK_QUANTITY, new BigDecimal(BULK_PRICE));

    @Test
    void testConstructorEmptyItemName() {
        assertAll("Item name as empty string to constructors.",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem("", new BigDecimal(ITEM_PRICE_ONE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle empty string as an "
                                + "argument to theName properly."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem("", new BigDecimal(ITEM_PRICE_ONE)),
                        "Two arg constructor does not handle empty string as an "
                                + "argument to theName properly."));

    }

    @Test
    void testConstructorNullItemName() {
        assertAll("Item name as null to constructors.",
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(null, new BigDecimal(ITEM_PRICE_ONE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle null as an "
                                + "argument to theName properly."),
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(null, new BigDecimal(ITEM_PRICE_ONE)),
                        "Two arg constructor does not handle null as an "
                                + "argument to theName properly."));

    }

    @Test
    void testConstructorNegativeItemPrice() {
        assertAll("Item price as negative value to constructors.",
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(NEGATIVE_PRICE),
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle negative value as an "
                                + "argument to thePrice properly."),
                () -> assertThrows(IllegalArgumentException.class,
                        () -> new StoreItem(ITEM_NAME, new BigDecimal(NEGATIVE_PRICE)),
                        "Two arg constructor does not handle negative value as an "
                                + "argument to thePrice properly."));

    }

    @Test
    void testConstructorNullItemPrice() {
        assertAll("Item price as null value to constructors.",
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(BULK_ITEM_NAME, null,
                                BULK_QUANTITY, new BigDecimal(BULK_PRICE)),
                        "Four arg constructor does not handle null as an "
                                + "argument to thePrice properly."),
                () -> assertThrows(NullPointerException.class,
                        () -> new StoreItem(ITEM_NAME, null),
                        "Two arg constructor does not handle null as an "
                                + "argument to thePrice properly."));

    }

    @Test
    void testConstructorNegativeBulkItemQuantity() {
        assertThrows(IllegalArgumentException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE_ONE),
                        -1, new BigDecimal(BULK_PRICE)),
                "Four arg constructor does not handle negative value as an "
                        + "argument to theBulkQuantity properly.");
    }

    @Test
    void testConstructorNullBulkItemPrice() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE_ONE),
                        BULK_QUANTITY, new BigDecimal(NEGATIVE_PRICE)),
                "Four arg constructor does not handle negative value as an "
                        + "argument to theBulkPrice properly.");
    }

    @Test
    void testConstructorNegativeBulkItemPrice() {
        assertThrows(NullPointerException.class,
                () -> new StoreItem(BULK_ITEM_NAME, new BigDecimal(ITEM_PRICE_ONE),
                        BULK_QUANTITY, null),
                "Four arg constructor does not handle null as an "
                        + "argument to thePrice properly.");
    }

    @Test
    void testTwoArguemntConstructor() {
        assertAll("Two argument constructor test.",
                () -> assertEquals(
                        ITEM_NAME,
                        TEST_ITEM_ONE.getName(),
                        "Item name should be: " + ITEM_NAME),
                () -> assertEquals(
                        new BigDecimal(ITEM_PRICE_ONE),
                        TEST_ITEM_ONE.getPrice(),
                        "Item Price should be: " + ITEM_PRICE_ONE),
                () -> assertEquals(
                        0,
                        TEST_ITEM_ONE.getBulkQuantity(),
                        "Bulk quantity should be: 0"),
                () -> assertEquals(
                        BigDecimal.ZERO,
                        TEST_ITEM_ONE.getBulkPrice(),
                        "Bulk Price should be: 0"));
    }

    @Test
    void testFourArgumentConstructor() {
        assertAll("Four argument constructor test.",
                () -> assertEquals(
                        BULK_ITEM_NAME,
                        TEST_BULK_ITEM.getName(),
                        "Item name should be: " + BULK_ITEM_NAME),
                () -> assertEquals(
                        new BigDecimal(ITEM_PRICE_ONE),
                        TEST_BULK_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE_ONE),
                () -> assertEquals(
                        BULK_QUANTITY,
                        TEST_BULK_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: " + BULK_QUANTITY),
                () -> assertEquals(
                        new BigDecimal(BULK_PRICE),
                        TEST_BULK_ITEM.getBulkPrice(),
                        "Bulk Price should be: " + BULK_PRICE));
    }

    @Test
    void testGetName() {
        assertAll("getName test.",
                () -> assertEquals(
                        ITEM_NAME,
                        TEST_ITEM_ONE.getName(),
                        "Item name should be: " + ITEM_NAME),
                () -> assertEquals(
                        BULK_ITEM_NAME,
                        TEST_BULK_ITEM.getName(),
                        "Item name should be: " + BULK_ITEM_NAME));
    }

    @Test
    void testGetPrice() {
        assertAll("getPrice test.",
                () -> assertEquals(
                        new BigDecimal(ITEM_PRICE_ONE),
                        TEST_BULK_ITEM.getPrice(),
                        "Item Price should be: " + ITEM_PRICE_ONE),
                () -> assertEquals(
                        new BigDecimal(ITEM_PRICE_ONE),
                        TEST_ITEM_ONE.getPrice(),
                        "Item Price should be: " + ITEM_PRICE_ONE));
    }

    @Test
    void testGetBulkQuantity() {
        assertAll("getBulkQuantity test.",
                () -> assertEquals(
                        0,
                        TEST_ITEM_ONE.getBulkQuantity(),
                        "Bulk quantity should be: 0"),
                () -> assertEquals(
                        BULK_QUANTITY,
                        TEST_BULK_ITEM.getBulkQuantity(),
                        "Bulk quantity should be: " + BULK_QUANTITY));
    }

    @Test
    void testGetBulkPrice() {
        assertAll("getBulkPrice test.",
                () -> assertEquals(
                        BigDecimal.ZERO,
                        TEST_ITEM_ONE.getBulkPrice(),
                        "Bulk Price should be: 0"),
                () -> assertEquals(
                        new BigDecimal(BULK_PRICE),
                        TEST_BULK_ITEM.getBulkPrice(),
                        "Bulk Price should be: " + BULK_PRICE));
    }

    @Test
    void testIsBulk() {
        assertAll("isBulk test.",
                () -> assertFalse(
                        TEST_ITEM_ONE.isBulk(),
                        "Item should NOT be bulk"),
                () -> assertTrue(
                        TEST_BULK_ITEM.isBulk(),
                        "Item should be bulk"));
    }

    @Test
    void testToString() {
        assertAll("toString test.",
                () -> assertEquals(
                        "Item, $0.50",
                        TEST_ITEM_ONE.toString(),
                        "toString should be: \"Item, $0.50\""),
                () -> assertEquals(
                        "Bulk Item, $0.50 (10 for $4.00)",
                        TEST_BULK_ITEM.toString(),
                        "toString should be: \"Bulk Item, $0.50 (10 for $4.00)\""));
    }

    @Test
    void testEquals() {
        assertAll("equals test.",
                () -> assertAll("equals test same object.",
                        () -> assertEquals(
                                TEST_ITEM_ONE,
                                TEST_ITEM_ONE,
                                "2 argument Same object should be equals() true"),
                        () -> assertEquals(
                                TEST_BULK_ITEM,
                                TEST_BULK_ITEM,
                                "4 argument Same object should be equals() true")),
                () -> assertAll("equals test different object same sate.",
                        () -> {
                            final Item twoArgument =
                                    new StoreItem(ITEM_NAME, new BigDecimal(ITEM_PRICE_ONE));
                            assertEquals(
                                    TEST_ITEM_ONE,
                                    twoArgument,
                                    "2 argument different objects with the same "
                                            + "state should be equals() true");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            BULK_ITEM_NAME,
                                            new BigDecimal(ITEM_PRICE_ONE),
                                            BULK_QUANTITY,
                                            new BigDecimal(BULK_PRICE));
                            assertEquals(
                                    TEST_BULK_ITEM,
                                    fourArgument,
                                    "4 argument different objects with the same "
                                            + "state should be equals() true");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            ITEM_NAME,
                                            new BigDecimal(ITEM_PRICE_ONE),
                                            0,
                                            BigDecimal.ZERO);
                            assertEquals(
                                    TEST_ITEM_ONE,
                                    fourArgument,
                                    "4 argument object with  0 bulk items and ZERO bulk "
                                            + "price and 2 argument object with same name and "
                                            + "price should be equals() true");
                        }));
    }

    @Test
    void testNotEquals() {
        assertAll("NOT equals test.",
                () -> assertAll("NOT equals test two argument.",
                        () -> {
                            final Item twoArgument =
                                    new StoreItem(
                                            ITEM_NAME + "wrong",
                                            new BigDecimal(ITEM_PRICE_ONE));
                            assertNotEquals(
                                    TEST_ITEM_ONE,
                                    twoArgument,
                                    "2 argument Different name should be false");
                        },
                        () -> {
                            final Item twoArgument =
                                    new StoreItem(
                                            ITEM_NAME,
                                            new BigDecimal("10" + ITEM_PRICE_ONE));
                            assertNotEquals(
                                    TEST_ITEM_ONE,
                                    twoArgument,
                                    "2 argument Different price should be false");
                        },
                        () -> {
                            final Item twoArgument =
                                    new StoreItem(
                                            ITEM_NAME + "wrong",
                                            new BigDecimal("10" + ITEM_PRICE_ONE));
                            assertNotEquals(
                                    TEST_ITEM_ONE,
                                    twoArgument,
                                    "2 argument Different name and price should be false");
                        }
                ),
                () -> assertAll("NOT equals test four argument.",
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            BULK_ITEM_NAME + "wrong",
                                            new BigDecimal(ITEM_PRICE_ONE),
                                            BULK_QUANTITY,
                                            new BigDecimal(BULK_PRICE));
                            assertNotEquals(
                                    TEST_BULK_ITEM,
                                    fourArgument,
                                    "4 argument Different name should be false");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            BULK_ITEM_NAME,
                                            new BigDecimal("10" + ITEM_PRICE_ONE),
                                            BULK_QUANTITY,
                                            new BigDecimal(BULK_PRICE));
                            assertNotEquals(
                                    TEST_BULK_ITEM,
                                    fourArgument,
                                    "4 argument Different price should be false");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            BULK_ITEM_NAME,
                                            new BigDecimal(ITEM_PRICE_ONE),
                                            10 + BULK_QUANTITY,
                                            new BigDecimal(BULK_PRICE));
                            assertNotEquals(
                                    TEST_BULK_ITEM,
                                    fourArgument,
                                    "4 argument Different bulk quantity should be false");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            BULK_ITEM_NAME,
                                            new BigDecimal(ITEM_PRICE_ONE),
                                            BULK_QUANTITY,
                                            new BigDecimal("10" + BULK_PRICE));
                            assertNotEquals(
                                    TEST_BULK_ITEM,
                                    fourArgument,
                                    "4 argument Different bulk price should be false");
                        },
                        () -> {
                            final Item fourArgument =
                                    new StoreItem(
                                            BULK_ITEM_NAME + "wrong",
                                            new BigDecimal("10" + ITEM_PRICE_ONE),
                                            10 + BULK_QUANTITY,
                                            new BigDecimal("10" + BULK_PRICE));
                            assertNotEquals(
                                    TEST_BULK_ITEM,
                                    fourArgument,
                                    "4 argument Different name, price, bulk quantity, "
                                            + "bulk price should be false");
                        }
                ));
    }

    @Test
    void testNotEqualsEdgeCases() {
        assertAll("NOT equals tests for edge cases.",
                () -> assertAll("NOT equals test null arguments.",
                        () -> assertNotEquals(
                                TEST_ITEM_ONE,
                                null,
                                "2 argument null argument should be false"),
                        () -> assertNotEquals(
                                TEST_BULK_ITEM,
                                null,
                                "4 argument null argument should be false")
                ),
                () -> assertAll("NOT equals test different type of arguments.",
                        () -> assertNotEquals(
                                TEST_ITEM_ONE,
                                "A String",
                                "2 argument String Object argument should be false"),
                        () -> assertNotEquals(
                                TEST_BULK_ITEM,
                                "A String",
                                "2 argument String Object argument should be false"),
                        () -> assertNotEquals(
                                TEST_ITEM_ONE,
                                new BigDecimal("9.99"),
                                "2 argument BigDecimal Object argument should be false"),
                        () -> assertNotEquals(
                                TEST_BULK_ITEM,
                                new BigDecimal("9.99"),
                                "4 argument BigDecimal Object argument should be false")
                ));
    }

    @Test
    void testHashCode() {
        assertAll("hashCode test.",
                () -> assertEquals(
                            TEST_ITEM_ONE.hashCode(),
                            TEST_ITEM_ONE.hashCode(),
                            "2 argument objects equal by equals must have the same hashCode"),
                () -> {
                    final Item twoArgument =
                            new StoreItem(ITEM_NAME, new BigDecimal(ITEM_PRICE_ONE));
                    assertEquals(
                            TEST_ITEM_ONE,
                            twoArgument,
                            "2 argument different objects with the same state "
                                    + "should be equals() true");
                    assertEquals(
                            TEST_ITEM_ONE.hashCode(),
                            twoArgument.hashCode(),
                            "2 argument objects equal by equals must have the same hashCode");
                },
                () -> assertEquals(
                            TEST_BULK_ITEM.hashCode(),
                            TEST_BULK_ITEM.hashCode(),
                            "4 argument objects equal by equals must have the same hashCode"),
                () -> {
                    final Item fourArgument =
                            new StoreItem(
                                    BULK_ITEM_NAME,
                                    new BigDecimal(ITEM_PRICE_ONE),
                                    BULK_QUANTITY,
                                    new BigDecimal(BULK_PRICE));
                    assertEquals(
                            TEST_BULK_ITEM,
                            fourArgument,
                            "4 argument different objects with the same state "
                                    + "should be equals() true");
                    assertEquals(
                            TEST_BULK_ITEM.hashCode(),
                            fourArgument.hashCode(),
                            "4 argument objects equal by equals must have the same hashCode");

                });
    }
    //EXTRA CREDIT TESTS
    @Test
    void testCompareTo() {
        assertAll("testing compareTo() extra credit",
                () -> assertEquals(0, TEST_ITEM_ONE.compareTo(TEST_ITEM_ONE),
                        "compareTo() compares same items incorrectly."),
                () -> assertTrue(TEST_BULK_ITEM.compareTo(TEST_ITEM_ONE) > 0,
                        "compareTo() should return 1 for Bulk Item.(Item)."),
                () -> assertTrue(TEST_ITEM_ONE.compareTo(TEST_BULK_ITEM) < 0,
                        "compareTo() should return -1 for Item.(Bulk Item).")
        );
    }

    @Test
    void testOrderByPrice() {
        assertAll("testing orderByPrice() extra credit",
                () -> assertEquals(0, TEST_ITEM_ONE.orderByPrice(TEST_ITEM_ONE),
                        "orderByPrice() compares same items incorrectly."),
                () -> assertTrue(TEST_ITEM_TWO.compareTo(TEST_ITEM_ONE) > 0,
                        "orderByPrice() should return 1 for 1.(0.5)."),
                () -> assertTrue(TEST_ITEM_ONE.compareTo(TEST_ITEM_TWO) < 0,
                        "orderByPrice() should return -1 for 0.5.(1).")
        );
    }
}