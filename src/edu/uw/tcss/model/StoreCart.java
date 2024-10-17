package edu.uw.tcss.model;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Class implementing the Cart interface to
 * create mutable StoreCart objects that store
 * StoreItemOrder objects in a HashMap.
 * 
 * @author Raiden H
 * @version 16-10-2024
 */
public class StoreCart implements Cart {
    /**
     * HashMap instance variable for ItemOrders in this StoreCart
     */
    private final Map<Item, ItemOrder> myOrderMap = new HashMap<>();
    /**
     * boolean membership status instance variable for this StoreCart
     */
    private boolean myMembershipStatus;
    /**
     * int ItemOrder count instance variable for this StoreCart
     */
    private int myItemOrderCount;
    /**
     * int Item count instance variable for this StoreCart
     */
    private int myItemCount;
    /**
     * Zero-arg constructor for creating instances of this class.
     */
    public StoreCart() {
        super();
    }
    @Override
    public void add(final ItemOrder theOrder) {
        myOrderMap.put(theOrder.getItem(), theOrder);
    }

    @Override
    public void setMembership(final boolean theMembership) {
        myMembershipStatus = theMembership;
    }

    @Override
    public BigDecimal calculateTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (final Map.Entry<Item, ItemOrder> entry : myOrderMap.entrySet()) {
            final Item k = entry.getKey();
            final ItemOrder v = entry.getValue();
            if (v.getItem().isBulk() && myMembershipStatus) {
                //quantity without any remainder post-bulk discount
                final int tempQuantity = v.getQuantity() - (v.getQuantity()
                        % v.getItem().getBulkQuantity());
                //adding single items total
                total = total.add(v.getItem().getPrice().multiply(
                        new BigDecimal(v.getQuantity() % v.getItem().getBulkQuantity())));
                //adding bulk discount items total
                total = total.add(v.getItem().getBulkPrice().multiply(
                        new BigDecimal(tempQuantity / v.getItem().getBulkQuantity())));
            } else {
                total = total.add(v.getItem().getPrice().multiply(
                        new BigDecimal(v.getQuantity())));
            }
        }
        return total;
    }

    @Override
    public void clear() {
        myOrderMap.clear();
    }

    @Override
    public CartSize getCartSize() {
        myItemOrderCount = 0;
        myItemCount = 0;
        myOrderMap.forEach((k, v) -> {
            if (v.getQuantity() != 0) {
                myItemOrderCount++;
                myItemCount += v.getQuantity();
            }
        });
        return new CartSize(myItemOrderCount, myItemCount);
    }

    /**
     * returns a string representation of this StoreCart object
     * and it's items.
     * @return string representation of the StoreCart object
     */
    public String toString() {
        final StringBuilder output = new StringBuilder();
        output.append(getCartSize().itemOrderCount());
        output.append(" item orders ");
        output.append(getCartSize().itemCount());
        output.append(" items. [");
        for (final Map.Entry<Item, ItemOrder> entry : myOrderMap.entrySet()) {
            output.append("(");
            output.append(entry.getValue().getItem().toString());
            output.append("), ");
        }
        if (output.charAt(output.length() - 2) == ',') {
            output.delete(output.length() - 2, output.length());
        }
        output.append("]");
        return output.toString();
    }
    //TODO: the extra credit! implement sorting on the HashMap, by name first then by price
    //then write a method orderByPrice() to order them by price instead (low to high)
    //you get bonus credit if orderByPrice() is a single line (try lambdas!)
}
