package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

public class Product implements Searchable {
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
    @Override
    public String[] getTags() {
        return new String[0];
    }

}
