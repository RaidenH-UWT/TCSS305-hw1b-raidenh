package edu.uw.tcss.model;

import java.math.BigDecimal;

/**
 * this interface represents the Cart object.
 * which stores item orders, cart size, and total cost
 *
 * @author Raiden H
 * @author Charles Bryan
 * @version 09-10-2024
 */

public interface Cart {
    /**
     * this method adds an ItemOrder object to the cart. new orders of the
     * same item will overwrite previous ones.
     *
     * @param theOrder the ItemOrder object to be added
     */
    void add(ItemOrder theOrder);

    /**
     * this method sets the membership status of the user. accepts
     * a boolean value.
     *
     * @throws IllegalArgumentException if non-boolean is passed
     * @param theMembership the membership status passed to the method
     */
    void setMembership(boolean theMembership);

    /**
     * this method calculates the total price of all ItemOrder
     * objects in the cart, accounting for bulk discounts if
     * the user is a member.
     *
     * @return BigDecimal total of all ItemOrder objects
     * in the cart
     */
    BigDecimal calculateTotal();

    /**
     * this method clears all ItemOrder objects in the cart.
     */
    void clear();

    /**
     * returns a string representation of this cart.
     *
     * @return String representation of this cart
     */
    String toString();

    /**
     * this method returns [...] CartSize object.
     *
     * @return a CartSize object containing [...]
     */
    CartSize getCartSize();

    /**
     * a Record CartSize object that stores an itemOrderCount
     * and itemCount for the specified cart. retrieved using getCartSize()
     *
     * @param itemOrderCount number of unique item orders in the cart
     * @param itemCount total quantity of items in the cart
     */
    record CartSize(int itemOrderCount, int itemCount) { }
}