package shop;

import java.util.Objects;

public class Product {
    private String productName;
    private int productPrice;

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (Objects.equals(productName, "")) {
            throw new IllegalArgumentException("Название продукта не может быть пустым!");
        } else {
            this.productName = productName;
        }
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public Product() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return productPrice == product.productPrice && productName.equals(product.productName);
    }

    @Override
    public int hashCode() {
        int result = productName == null ? 0 : productName.hashCode();
        result = 31 * result + productPrice;
        return result;
    }

    @Override
    public String toString() {
        return "Продукты: {" +
                "Наименование продукта: '" + productName + '\'' +
                ", цена продукта: " + productPrice +
                '}';
    }
}
