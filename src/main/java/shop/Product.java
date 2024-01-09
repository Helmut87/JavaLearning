package shop;

import java.util.Objects;

import static org.apache.commons.lang3.math.NumberUtils.isDigits;

public class Product {
    private String productName;
    private int productPrice;
    private DiscountProduct discount;
    private boolean isDiscounted;

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

    public DiscountProduct getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountProduct discount) {
        this.discount = discount;
    }

    public boolean isDiscounted() {
        return isDiscounted;
    }

    public void setDiscounted(boolean isDiscounted) {
        this.isDiscounted = isDiscounted;
    }

    public Product(String productName, int productPrice, DiscountProduct discount) {
        this.productName = productName;
        this.productPrice = productPrice;
        this.discount = discount;
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
        if (discount != null) {
            sb.append(", размер скидки: ").append(discount.getDiscountAmount());
            sb.append(", срок действия скидки: ").append(discount.getExpirationDate());
        }
        sb.append("}");
        return sb.toString();
    }
}