package org.skypro.skyshop.product;

public class DiscountedProduct extends Product {
    private int defaultPrice;
    private int discount;

    public DiscountedProduct(String name, int defaultPrice, int discount) {
        super(name, defaultPrice);

        if (defaultPrice <= 0) {
            throw new IllegalArgumentException("Базовая цена продукта не может быть меньше 0.");
        }
        if (discount < 0 || discount > 100) {
            throw new IllegalArgumentException("Скидка может быть только в диапазоне от 0 до 100 включительно.");
        }
        this.defaultPrice = defaultPrice;
        this.discount = discount;
    }

    @Override
    public int getFinalPrice() {
        return defaultPrice - (defaultPrice * discount/100);
    }

    @Override
    public String[] getTags() {
        return new String[0];
    }

    @Override
    public String toString() {
        return super.toString() +
                ", базовая цена=" + defaultPrice +
                ", скидка=" + discount + "%" +
                ", цена со скидкой=" + getFinalPrice();
    }

}
