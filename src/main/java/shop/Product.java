package shop;

import java.time.LocalDate;
import java.util.Objects;

import static org.apache.commons.lang3.math.NumberUtils.isDigits;

public class Product {
    private String productName;
    private int productPrice;
    private int discountAmount;
    private LocalDate discountExpirationDate;

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        if (discountAmount < 0) {
            throw new IllegalArgumentException("Discount amount cannot be negative.");
        }
        this.discountAmount = discountAmount;
    }

    public LocalDate getDiscountExpirationDate() {
        return discountExpirationDate;
    }

    public void setDiscountExpirationDate(LocalDate discountExpirationDate) {
        this.discountExpirationDate = discountExpirationDate;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        if (Objects.equals(productName, "") || isDigits(productName)) {
            throw new IllegalArgumentException("Название продукта не может быть пустым и (или) содержать только цифры");
        } else if (productName.length() < 3) {
            throw new IllegalArgumentException("Название продукта не может содержать меньше чем 3 символа");
        } else {
            this.productName = productName;
        }
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        if (productPrice <= 0) {
            throw new IllegalArgumentException("Цена продукта не может быть равной и (или) меньше 0!");
        } else {
            this.productPrice = productPrice;
        }
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
        StringBuilder sb = new StringBuilder();
        sb.append("Продукты: {");
        sb.append("Наименование продукта: '").append(productName).append("'");
        sb.append(", цена продукта: ").append(productPrice);
        if (discountAmount > 0 && discountExpirationDate != null) {
            sb.append(", размер скидки: ").append(discountAmount);
            sb.append(", срок действия скидки: ").append(discountExpirationDate);
        }
        sb.append("}");
        return sb.toString();
    }
}