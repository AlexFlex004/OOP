package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int defaultPrice;
    private int discount;

    public DiscountedProduct(String name, int defaultPrice, int discount) {
        super(name, defaultPrice);
        this.defaultPrice = defaultPrice;
        this.discount = discount;
    }

    @Override
    public double getPrice() {
        return defaultPrice - (defaultPrice * discount/100);
    }



    @Override
    public String toString() {
        return getName() + ": " + getPrice() + " (" + discount + "%)";
    }

}
