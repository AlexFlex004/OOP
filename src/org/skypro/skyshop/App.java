package org.skypro.skyshop;

import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;


public class App {
    public static void main(String[] args) {

        ProductBasket basket1 = new ProductBasket();

        Product product1 = new Product("Шоколад", 98);
        Product product2 = new Product("Молоко", 80);
        Product product3 = new Product("Сыр", 60);
        Product product4 = new Product("Чипсы", 150);
        Product product5 = new Product("Колбаса", 200);

        basket1.addProduct(product1);
        basket1.addProduct(product2);
        basket1.addProduct(product3);
        basket1.addProduct(product4);
        basket1.addProduct(product5);

        basket1.printProductBasket();

        System.out.println();
        basket1.checkProduct("Сыр");

        basket1.clearBasket();





        }
    }