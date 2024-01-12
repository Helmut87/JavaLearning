package shop;

import java.time.LocalDate;
import java.util.Objects;

public class DiscountProduct {
    private int discountAmount;
    private LocalDate expirationDate;

    public DiscountProduct(int discountAmount, LocalDate expirationDate) {
        this.discountAmount = discountAmount;
        this.expirationDate = expirationDate;
    }

    public DiscountProduct() {
    }

    public int getDiscountAmount() {
        return discountAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        if (discountAmount <= 0) {
            throw new IllegalArgumentException("Размер скидки должен быть положительным числом.");
        }
        this.discountAmount = discountAmount;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DiscountProduct discount = (DiscountProduct) o;
        return discountAmount == discount.discountAmount &&
                expirationDate.equals(discount.expirationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(discountAmount, expirationDate);
    }
}
