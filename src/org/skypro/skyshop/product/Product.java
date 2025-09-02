package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public abstract class Product implements Searchable {
    private String name;
    private int price;

    public Product(String name, int price) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Название продукта не может быть пустым или состоять только из пробелов.");
        }

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


    @Override
    public String toString() {
        return name + " — " + price + "₽";
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    @Override
    public String getContentType() {
        return "PRODUCT";
    }

    public abstract int getFinalPrice();

    @Override
    public String[] getTags() {
        return new String[0];
    }



}
