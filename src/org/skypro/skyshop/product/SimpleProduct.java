package org.skypro.skyshop.product;

public class SimpleProduct extends Product {
    private int price;
    private String name;

    public SimpleProduct(String name, int price) {
        super(name, price);
        this.price = price;
    }

    @Override
    public int getPrice() {
        return price;
    }


    @Override
    public String toString() {
        return getName() + ": " + getPrice();
    }

    @Override
    public String[] getTags() {
        return new String[0];
    }
}
