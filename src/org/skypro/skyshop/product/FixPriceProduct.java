package org.skypro.skyshop.product;

public class FixPriceProduct extends Product {
    private static final int FIXED_PRICE = 100;

    public FixPriceProduct(String name) {
        super(name);
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
    public String[] getTags() {
        return new String[0]; // пока без тегов
    }

    @Override
    public String getContentType() {
        return "Продукт (фиксированная цена)";
    }

    @Override
    public String toString() {
        return getName() + ": фиксированная цена " + FIXED_PRICE + " руб.";
    }
}