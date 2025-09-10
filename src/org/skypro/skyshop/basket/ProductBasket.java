package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;

public class ProductBasket {
    // вместо List<Product> теперь Map<Имя, Список продуктов>
    private final Map<String, List<Product>> products;

    public ProductBasket() {
        this.products = new HashMap<>();
    }

    // Добавление продукта
    public void addProduct(Product product) {
        products
                .computeIfAbsent(product.getName().toLowerCase(), k -> new ArrayList<>())
                .add(product);
    }

    // Удаление всех продуктов с данным именем
    public List<Product> removeByName(String name) {
        return products.remove(name.toLowerCase());
    }

    // Получение списка по имени (например, просто посмотреть)
    public List<Product> getByName(String name) {
        return products.getOrDefault(name.toLowerCase(), Collections.emptyList());
    }

    // Печать содержимого корзины
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
        } else {
            System.out.println("Содержимое корзины:");
            for (Map.Entry<String, List<Product>> entry : products.entrySet()) {
                for (Product product : entry.getValue()) {
                    System.out.println(" - " + product);
                }
            }
        }
    }
}
