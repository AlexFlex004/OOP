package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;
import java.util.Set;

public class App {
    public static void main(String[] args) {

        SearchEngine searchEngine = new SearchEngine();
        ProductBasket basket = new ProductBasket();

        // Демонстрация проверок
        try {
            Product p1 = new SimpleProduct("   ", 100);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product p2 = new SimpleProduct("Спиннинг", 0);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        try {
            Product p3 = new DiscountedProduct("Фонарь", 600, 150);
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Добавляем товары в поисковый движок
        searchEngine.add(new SimpleProduct("Спиннинг рыболовный", 10000));
        searchEngine.add(new DiscountedProduct("Фонарь", 600, 10));
        searchEngine.add(new SimpleProduct("Лодка", 50000));

        // Демонстрация поиска
        System.out.println();
        System.out.println("Результаты поиска по слову 'спин':");
        Set<Searchable> searchResults = searchEngine.search("спин");
        for (Searchable result : searchResults) {
            System.out.println(" - " + result);
            basket.addProduct((Product) result); // добавляем найденные товары в корзину
        }

        System.out.println();
        basket.printBasket();

        // Удаление существующего продукта
        System.out.println("\nУдаляем 'Спиннинг рыболовный'...");
        List<Product> removed = basket.removeByName("Спиннинг рыболовный");
        if (removed != null && !removed.isEmpty()) {
            System.out.println("Удалены:");
            for (Product product : removed) {
                System.out.println(" - " + product);
            }
        } else {
            System.out.println("Не найдено товаров для удаления.");
        }
        basket.printBasket();

        // Удаление несуществующего продукта
        System.out.println("\nУдаляем 'Снасть'...");
        List<Product> removed2 = basket.removeByName("Снасть");
        if (removed2 == null || removed2.isEmpty()) {
            System.out.println("Список пуст или товар не найден");
        }
        basket.printBasket();
    }
}