package org.skypro.skyshop.basket;
import org.skypro.skyshop.product.Product;

import java.util.Arrays;

public class ProductBasket {
    private Product[] products;
    private int amount;

    public ProductBasket() {
        this.products = new Product[5];
        this.amount = 0;
    }

    public void addProduct(Product product) {
        if (amount < products.length) {
            products[amount] = product;
            amount++;
        } else {
            System.out.println("Корзина переполнена.");
        }
    }

    public int getTotalPrice() {
        int total = 0;
        for (int i = 0; i < amount; i++) {
            total += products[i].getPrice();
        }
        return total;
    }

    public void printProductBasket() {
        if (amount == 0) {
            System.out.println("В корзине пусто");
            return;
        }
        for (Product product : products) {
            if (product != null) {
                System.out.println(product.getName() + ": " + product.getPrice());
            }
        }
        System.out.println("Итого: " + getTotalPrice());
    }

    public boolean checkProduct (String name) {
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(product.getName())) {
                System.out.println("Продукт находится в корзине.");
                return true;

            }
        }
        return false;
    }

    public void clearBasket () {
        Arrays.fill(products, null);
    }

}
