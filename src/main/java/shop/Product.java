package shop;

import java.util.Objects;

import static org.apache.commons.lang3.math.NumberUtils.isDigits;

public class Product {
    private String productName;
    private int productPrice;
    private DiscountProduct discount;

    public DiscountProduct getDiscount() {
        return discount;
    }

    public void setDiscount(DiscountProduct discount) {
        this.discount = discount;
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
        if (discount != null) {
            sb.append(", ������ ������: ").append(discount.getDiscountAmount());
            sb.append(", ���� �������� ������: ").append(discount.getExpirationDate());
        }
        sb.append("}");
        return sb.toString();
    }
}