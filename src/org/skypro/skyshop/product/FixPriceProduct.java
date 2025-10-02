package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name, FIXED_PRICE);
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым.");
        }
    }


    @Override
    public int getPrice() {
        return FIXED_PRICE;
    }

    @Override
    public int getFinalPrice() {
        return FIXED_PRICE;
    }


    @Override
    public String toString() {
        return getName() + ": фиксированная цена " + FIXED_PRICE + " руб.";
    }
}