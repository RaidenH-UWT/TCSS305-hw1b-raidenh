// Finish and comment me!

package edu.uw.tcss.model;

/**
 * this class implementes the ItemOrder interface and creates
 * immutable StoreItemOrder objects with an Item and an int quantity.
 *
 * @author Raiden H
 * @version 16-10-2024
 */
public final class StoreItemOrder implements ItemOrder {

    /**
     * quantity instance variable for this object
     */
    private final int myQuantity;
    /**
     * item instance variable for this object
     */
    private final StoreItem myItem;

    /**
     * this constructor accepts two arguments to instantiate StoreItemOrder objects.
     *
     * @throws NullPointerException if theItem is null
     * @throws IllegalArgumentException if theQuantity is less than zero
     * @param theItem a StoreItem object
     * @param theQuantity an integer quantity
     */
    public StoreItemOrder(final Item theItem, final int theQuantity) {
        super();
        if (theItem == null) {
            throw new NullPointerException("Parameters cannot be null");
        } else if (theQuantity < 0) {
            throw new IllegalArgumentException("Quantity must not be negative");
        }
        myItem = new StoreItem(theItem.getName(), theItem.getPrice(),
                theItem.getBulkQuantity(), theItem.getBulkPrice());
        myQuantity = theQuantity;
    }


    @Override
    public Item getItem() {
        return myItem;
    }
    

    @Override
    public int getQuantity() {
        return myQuantity;
    }

    @Override
    public String toString() {
        final StringBuilder output = new StringBuilder();
        if (myItem.isBulk()) {
            output.append(myItem.getName());
            output.append(", $");
            output.append(myItem.getPrice());
            output.append(" (");
            output.append(myItem.getBulkQuantity());
            output.append(" for $");
            output.append(myItem.getBulkPrice());
            output.append(")");
        } else {
            output.append(myItem.getName());
            output.append(", $");
            output.append(myItem.getPrice());
        }
        output.append(", ");
        output.append(myQuantity);
        return output.toString();
    }
}
