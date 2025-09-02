package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.product.SimpleProduct;

public class App {
    public static void main(String[] args) {
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

        SearchEngine engine = new SearchEngine(10);


        engine.add(new SimpleProduct("Спиннинг рыболовный", 10000));
        engine.add(new DiscountedProduct("Фонарь", 600, 10));
        engine.add(new SimpleProduct("Лодка", 50000));

        /// ///
        System.out.println();
        System.out.println("УДАЧНЫЙ");
        try {
            Searchable result = engine.findBestMatch("Спиннинг");
            System.out.println("Найден лучший результат: " + result);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }

        /// ///
        System.out.println();
        System.out.println("НЕУДАЧНЫЙ");
        try {
            Searchable result = engine.findBestMatch("Телефон");
            System.out.println("Найден лучший результат: " + result);
        } catch (BestResultNotFound e) {
            System.out.println("Ошибка поиска: " + e.getMessage());
        }
    }
}