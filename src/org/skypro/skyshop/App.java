package org.skypro.skyshop;

import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.List;

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

        SearchEngine engine = new SearchEngine();


        searchEngine.add(new SimpleProduct("Спиннинг рыболовный", 10000));
        searchEngine.add(new DiscountedProduct("Фонарь", 600, 10));
        searchEngine.add(new SimpleProduct("Лодка", 50000));

        // Демонстрация поиска
        System.out.println();
        System.out.println("Результаты поиска по слову 'спин':");
        List<Searchable> searchResults = searchEngine.search("спин");
        for (Searchable product : searchResults) {
            System.out.println(" - " + product);
            basket.addProduct((Product) product); // добавим найденные в корзину
        }

        System.out.println();
        basket.printBasket();

        // Удаление существующего продукта
        System.out.println();
        System.out.println("\nУдаляем 'Спиннинг'...");
        List<Product> removed = basket.removeByName("Спиннинг");
        if (!removed.isEmpty()) {
            System.out.println("Удалены:");
            for (Product product : removed) {
                System.out.println(" - " + product);
            }
        }
        basket.printBasket();

        // Удаление несуществующего продукта
        System.out.println("\nУдаляем 'Снасть'...");
        List<Product> removed2 = basket.removeByName("Снасть");
        if (removed2.isEmpty()) {
            System.out.println("Список пуст");
        }
        basket.printBasket();
    }
}