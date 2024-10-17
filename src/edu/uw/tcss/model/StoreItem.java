package edu.uw.tcss.model;

import java.math.BigDecimal;
import java.util.Objects;
import java.util.logging.Logger;

//i don't think i can do any JS inside  a javadoc
//which is fair lol.

//the warning here is just incorrect, this is the correct formatting
//for a background image using a url. it's not detecting it as a
//css property but a bit of the text that it wants inside an <a> tag
/**
 * <p style="background-image:url(https://endy-boi.neocities.org/short_rainbow_gradient.png);
 *      color:black; font-weight:bold; font-size:18pt;">
 *     this class implementes the Item interface and creates instanced StoreItem objects.
 * </p>
 *
 * @author Raiden H
 * @version 13-10-2024
 */
public class StoreItem implements Item {
    /**
     * logger object for logging.
     */
    private static final Logger LOGGER = Logger.getLogger(StoreItem.class.getName());

    /**
     * name instance variable.
     */
    private final String myName;
    /**
     * price instance variable.
     */
    private final BigDecimal myPrice;
    /**
     * bulk quantity instance variable.
     */
    private final int myBulkQuantity;
    /**
     * bulk price instance variable.
     */
    private final BigDecimal myBulkPrice;

    /**
     * This constructor creates an Item instance and stores it's name and price.
     *
     * @throws NullPointerException if theName or thePrice is null
     * @throws IllegalArgumentException if theName is empty or if thePrice is less than 0
     * @param theName the String name of the item to be stored
     * @param thePrice the BigDecimal price of a single item
     */
    public StoreItem(final String theName, final BigDecimal thePrice) {
        this(theName, thePrice, 0, BigDecimal.ZERO);
    }

    /**
     * This constructor creates an Item instance and store it's name, price, and optionally its
     * bulk quantity and bulk price. Usable with two (theName, thePrice) arguments or
     * four (theName, thePrice, theBulkQuantity, theBulkPrice).
     * @throws NullPointerException if theName, thePrice, or theBulkPrice is null
     * @throws IllegalArgumentException if theName is empty or if theBulkQuantity, thePrice, or
     * theBulkPrice is less than 0
     * @param theName the String name of the item to be stored
     * @param thePrice the BigDecimal price of a single item
     * @param theBulkQuantity optional; the int quantity for a bulk item to be sold in
     * @param theBulkPrice optional; the BigDecimal price for theBulkQuantity number of items
     */
    public StoreItem(final String theName, final BigDecimal thePrice,
                     final int theBulkQuantity, final BigDecimal theBulkPrice) {
        super();
        if (theName == null
                || thePrice == null
                || theBulkPrice == null) {
            throw new NullPointerException("Parameters cannot be null");
        } else if (theName.isEmpty()
                || theBulkQuantity < 0
                || thePrice.compareTo(BigDecimal.ZERO) < 0
                || theBulkPrice.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Check parameter value requirements");
        }
        myName = theName;
        myPrice = thePrice;
        myBulkQuantity = theBulkQuantity;
        myBulkPrice = theBulkPrice;
    }

    @Override
    public String getName() {
        return myName;
    }

    @Override
    public BigDecimal getPrice() {
        return myPrice;
    }

    @Override
    public int getBulkQuantity() {
        return myBulkQuantity;
    }

    @Override
    public BigDecimal getBulkPrice() {
        return myBulkPrice;
    }

    @Override
    public boolean isBulk() {
        return myBulkQuantity != 0;
    }

    @Override
    public String toString() {
        final StringBuilder output = new StringBuilder();
        if (isBulk()) {
            output.append(getName());
            output.append(", $");
            output.append(getPrice());
            output.append(" (");
            output.append(getBulkQuantity());
            output.append(" for $");
            output.append(getBulkPrice());
            output.append(")");
        } else {
            output.append(getName());
            output.append(", $");
            output.append(getPrice());
        }
        return output.toString();
    }

    @Override
    public boolean equals(final Object theOther) {
        boolean result = false;
        if (!(theOther == null || getClass() != theOther.getClass())) {
            final StoreItem asStoreItem = (StoreItem) theOther;
            result = myName.equals(asStoreItem.myName)
                    && myPrice.equals(asStoreItem.myPrice)
                    && myBulkQuantity == asStoreItem.myBulkQuantity
                    && myBulkPrice.equals(asStoreItem.myBulkPrice);
        }
        return result;
    }

    @Override
    public int hashCode() {
        return Objects.hash(myName, myPrice, myBulkQuantity, myBulkPrice);
    }
}
