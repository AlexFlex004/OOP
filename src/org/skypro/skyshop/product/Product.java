package org.skypro.skyshop.product;

public class Product {
    private String name;
    private int price;

    public Product(String name, int price) {
        this.name = name;
        this.price = price;
    }

    /// GETTERS ///
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }

}
