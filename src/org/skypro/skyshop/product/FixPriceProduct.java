package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name, FIXED_PRICE);
    }

    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }


    @Override
    public String toString() {
        return getName() + ": Фиксированная цена " + FIXED_PRICE;
    }

    @Override
    public String[] getTags() {
        return new String[0];
    }
}
