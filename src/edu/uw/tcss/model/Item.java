package edu.uw.tcss.model;

import java.math.BigDecimal;

/**
 * Represents a single item for sale. An Item is an immutable object.
 * <p>
 * Constructors and methods of this class throw NullPointerException if required
 * parameters are null.
 *
 * @author Charles Bryan
 * @version Autumn 2023
 */
public interface Item {
    /**
     * Returns the name for this Item.
     *
     * @return the name for this Item
     */
    String getName();

    /**
     * Returns the price for this Item.
     *
     * @return the price for this Item
     */
    BigDecimal getPrice();

    /**
     * Returns the bulk quantity for this Item.
     *
     * @return the bulk quantity for this Item
     */
    int getBulkQuantity();

    /**
     * Returns the bulk price for this Item.
     *
     * @return the bulk price for this Item
     */
    BigDecimal getBulkPrice();

    /**
     * Returns True if this Item has bulk pricing.
     *
     * @return True if this Item has bulk pricing; false otherwise
     */
    boolean isBulk();

    /**
     * StoreItem is compared to the given StoreItem by price, returning
     * a positive int, zero, or negative int if it's greater, equal, or less.
     *
     * @return a negative integer, zero, or a positive integer as this StoreItem's
     * price is less than, equal to, or greater than the specified StoreItem
     */
    int orderByPrice(StoreItem theOther);
}
