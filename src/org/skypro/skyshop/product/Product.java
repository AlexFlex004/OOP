package org.skypro.skyshop.product;

import org.skypro.skyshop.Searchable;

import java.util.Objects;

public abstract class Product implements Searchable {
    private final String name;

    public Product(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException("Имя продукта не может быть пустым.");
        }
        this.name = name;
    }

    @Override
    public String getSearchTerm() {
        return name;
    }

    public String getName() {
        return name;
    }

    // Каждому продукту по умолчанию указываем тип "Продукт"
    @Override
    public String getContentType() {
        return "Продукт";
    }

    @Override
    public abstract String[] getTags();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Product{name='" + name + "'}";
    }
}