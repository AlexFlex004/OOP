package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ProductBasket {
    private List<Product> products = new ArrayList<>();

    public void add(Product product) {
        products.add(product);
    }

    public void print() {
        int total = 0;
        int specialCount = 0;

        for (Product p : products) {
            System.out.println(p.toString());
            total += p.getPrice();

            }
        }


    }

