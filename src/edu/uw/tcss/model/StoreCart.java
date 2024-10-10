// Finish and comment me!

package edu.uw.tcss.model;

import java.math.BigDecimal;  

public class StoreCart implements Cart {

    public StoreCart() { }

    @Override
    public void add(final ItemOrder theOrder) { }

    @Override
    public void setMembership(final boolean theMembership) { }

    @Override
    public BigDecimal calculateTotal() {
        return null;
    }

    @Override
    public void clear() { }

    @Override
    public CartSize getCartSize() {
        return new CartSize(10, 20);
    }


    public String toString() {
        return null;
    }

}
