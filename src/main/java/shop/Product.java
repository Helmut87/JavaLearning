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
            throw new IllegalArgumentException("�������� �������� �� ����� ���� ������ � (���) ��������� ������ �����");
        } else if (productName.length() < 3) {
            throw new IllegalArgumentException("�������� �������� �� ����� ��������� ������ ��� 3 �������");
        } else {
            this.productName = productName;
        }
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        if (productPrice <= 0) {
            throw new IllegalArgumentException("���� �������� �� ����� ���� ������ � (���) ������ 0!");
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
        sb.append("��������: {");
        sb.append("������������ ��������: '").append(productName).append("'");
        sb.append(", ���� ��������: ").append(productPrice);
        if (discountAmount > 0 && discountExpirationDate != null) {
            sb.append(", ������ ������: ").append(discountAmount);
            sb.append(", ���� �������� ������: ").append(discountExpirationDate);
        }
        sb.append("}");
        return sb.toString();
    }
}