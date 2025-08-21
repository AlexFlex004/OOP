package org.skypro.skyshop;

import org.skypro.skyshop.product.DiscountedProduct;
import org.skypro.skyshop.product.FixPriceProduct;
import org.skypro.skyshop.product.Product;
import org.skypro.skyshop.basket.ProductBasket;
import org.skypro.skyshop.product.SimpleProduct;


public class App {
    public static void main(String[] args) {

        ProductBasket basket = new ProductBasket();

        Product p1 = new SimpleProduct("Кола", 162);
        Product p2 = new DiscountedProduct("Стейк сёмги", 300, 10);
        Product p3 = new FixPriceProduct("Рулетка");

        basket.add(p1);
        basket.add(p2);
        basket.add(p3);

        basket.print();
    }
    }