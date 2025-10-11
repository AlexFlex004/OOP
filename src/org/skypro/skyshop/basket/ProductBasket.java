package org.skypro.skyshop.basket;

import org.skypro.skyshop.product.Product;

import java.util.*;
import java.util.stream.Collectors;

public class ProductBasket {

    private final Map<String, List<Product>> products = new HashMap<>();

    //НОВЫЙ
    public void addProduct(Product product) {
        products
                .computeIfAbsent(product.getName().toLowerCase(), k -> new ArrayList<>())
                .add(product);
    }

    //УДАЛЕНИЕ ПО ИМЕНИ
    public List<Product> removeByName(String name) {
        return products.remove(name.toLowerCase());
    }

    //СПИСОК ПО ИМЕНИ
    public List<Product> getByName(String name) {
        return products.getOrDefault(name.toLowerCase(), Collections.emptyList());
    }

    //ВСЕГО ЦЕНА
    public int getTotalPrice() {
        return products.values().stream()
                .flatMap(Collection::stream)             // превращаем Map<name, List<Product>> → Stream<Product>
                .mapToInt(Product::getFinalPrice)         // достаём цены
                .sum();                                   // суммируем
    }

    //ВСЕГО ПРОДУКТЫ
    private int getCount() {
        return products.values().stream()
                .mapToInt(List::size)
                .sum();
    }

    //ОСОБЫЕ
    private long getSpecialCount() {
        return products.values().stream()
                .flatMap(Collection::stream)
                .filter(Product::isSpecial)
                .count();
    }

    //ПЕЧАТЬ
    public void printBasket() {
        if (products.isEmpty()) {
            System.out.println("Корзина пуста.");
            return;
        }

        System.out.println("Содержимое корзины:");
        products.values().stream()
                .flatMap(Collection::stream)
                .forEach(product -> System.out.println(" - " + product));

        System.out.println("Всего товаров: " + getCount());
        System.out.println("Из них специальных: " + getSpecialCount());
        System.out.println("Общая стоимость: " + getTotalPrice());
    }
}