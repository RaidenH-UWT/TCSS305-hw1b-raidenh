package edu.uw.tcss.model;

/**
 * this interface represents an immutable ItemOrder
 * object, which stores an Item and quantity (int).
 *
 * @author Raiden H
 * @author Charles Bryan
 * @version 10-10-2024
 */
public interface ItemOrder {

    /**
     * gets a reference to the Item in this ItemOrder.
     *
     * @return an Item object associated with this ItemOrder
     */
    Item getItem();

    /**
     * returns the number of Items for this ItemOrder.
     *
     * @return an int quantity of Items
     */
    int getQuantity();

    /**
     * returns a string represenation of this ItemOrder object
     * in a more human-readable format.
     *
     * @return String representation of the ItemOrder object
     */
    String toString();
}