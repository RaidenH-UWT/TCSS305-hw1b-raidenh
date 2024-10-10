package edu.uw.tcss.model;

import java.math.BigDecimal;

/**
 * this interface represents the Cart object
 * which stores item orders, cart size, and total cost
 *
 * @author Raiden H
 * @author Charles Bryan
 * @version 09-10-2024
 */

public interface Cart {
    /**
     * this method adds an ItemOrder object to the cart
     *
     * @param theOrder the ItemOrder object to be added
     */
    void add(ItemOrder theOrder);

    /**
     * this method sets the membership status of the user. accepts
     * a boolean value
     *
     * @throws IllegalArgumentException if non-boolean is passed
     * @param theMembership the membership status passed to the method
     */
    void setMembership(boolean theMembership);

    /**
     * this method calculates the total price of all ItemOrder
     * objects in the cart, accounting for bulk discounts if
     * the user is a member
     *
     * @return BigDecimal total of all ItemOrder objects
     * in the cart
     */
    BigDecimal calculateTotal();

    /**
     * this method clears all ItemOrder objects in the cart
     */
    void clear();

    // TODO: figure out what all this is actually supposed to tell you. is it like a toString() of the itemOrderCount and itemCount? is it a single value? what's goin on.
    /**
     * this method returns [...] CartSize object
     *
     * @return a CartSize object containing [...]
     */
    CartSize getCartSize();

    // TODO: figure out what i'm supposed to do with this. this is like, a class, not a method i'm including in the interface. it's not static either, i'm not sure why this is in the interface.
    /**
     *
     *
     * @param itemOrderCount
     * @param itemCount
     */
    record CartSize(int itemOrderCount, int itemCount) { }
    // https://docs.oracle.com/en/java/javase/17/language/records.html

    /**
     * returns a string representation of this cart
     *
     * @return String representation of this cart
     */
    String toString();
}