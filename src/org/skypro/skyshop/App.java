package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;

import java.util.Arrays;


public class App {
    public static void main(String[] args) {

        ///ПОИСКОВИК///
        SearchEngine engine = new SearchEngine(20);

        // Добавляем товары
        Product p1 = new Product("Спиннинг", 11000);
        Product p2 = new Product("Комплект наживок", 500);
        Product p3 = new Product("Набор снастей", 700);

        engine.add(p1);
        engine.add(p2);
        engine.add(p3);

        // Добавляем статьи
        Article a1 = new Article("Как выбрать спиннинг", "В статье рассказываем о критериях выбора удочки.",
                "удочка, удочки, спиннинг, спиннинги, спиннинга, выбор удочки");
        Article a2 = new Article("Обзор наживок", "Сравнение популярных наживок для рыбалки.",
                "наживка, наживок, наживки, наживка купить, черви, силиконовая, блесна, наживку, блесну");
        Article a3 = new Article("Снасти", "Снасти для каждого типа рыбалки.",
                "снасть, снасти, снастей, кормушка, донка, донная, донную");

        engine.add(a1);
        engine.add(a2);
        engine.add(a3);

        // Тестируем поиск
        System.out.println("=== Поиск 'спиннинг' ===");
        Arrays.stream(engine.search("спиннинг"))
                .filter(r -> r != null)
                .forEach(r -> System.out.println(r.getStringRepresentation()));

        System.out.println("\n=== Поиск 'наживка' ===");
        Arrays.stream(engine.search("Комплект наживок"))
                .filter(r -> r != null)
                .forEach(r -> System.out.println(r.getStringRepresentation()));

        System.out.println("\n=== Поиск 'снасть' ===");
        Arrays.stream(engine.search("набор снастей"))
                .filter(r -> r != null)
                .forEach(r -> System.out.println(r.getStringRepresentation()));
    }
}