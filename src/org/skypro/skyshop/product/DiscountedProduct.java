package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private final int defaultPrice;
    private final int discount;

    public DiscountedProduct(String name, int defaultPrice, int discount) {
        super(name);

        if (defaultPrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта должна быть больше 0.");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка должна быть в диапазоне от 0 до 100%.");
        }

        this.defaultPrice = defaultPrice;
        this.discount = discount;
    }

    @Override
    public int getPrice() {
        return defaultPrice;
    }

    @Override
    public int getFinalPrice() {
        return defaultPrice - (defaultPrice * discount / 100);
    }

    @Override
    public String[] getTags() {
        return new String[0]; // пока тегов нет
    }

    @Override
    public String getContentType() {
        return "Продукт со скидкой";
    }

    @Override
    public String toString() {
        return getName() +
                ": базовая цена = " + defaultPrice +
                ", скидка = " + discount + "%" +
                ", цена со скидкой = " + getFinalPrice();
    }
}