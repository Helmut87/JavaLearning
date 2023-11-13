package shop;

import java.util.ArrayList;
import java.util.Objects;

public class Person {
    private String personName;
    private int personAge;
    private int personCash;
    private ArrayList<Product> personShoppingCart;

    public Person(String personName, int personAge, int personCash, ArrayList<Product> personShoppingCart) {
        this.personName = personName;
        this.personAge = personAge;
        this.personCash = personCash;
        this.personShoppingCart = personShoppingCart;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        if (Objects.equals(personName, "")) {
            throw new IllegalArgumentException("Имя покупателя не может быть пустым!");
        } else {
            this.personName = personName;
        }
    }

    public int getPersonAge() {
        return personAge;
    }

    public void setPersonAge(int personAge) {
        this.personAge = personAge;
    }

    public int getPersonCash() {
        return personCash;
    }

    public void setPersonCash(int personCash) {
        if (personCash < 0) {
            throw new IllegalArgumentException("Деньги не могут быть отрицательным числом!");
        } else {
            this.personCash = personCash;
        }
    }

    public ArrayList<Product> getPersonShoppingCart() {
        return personShoppingCart;
    }

    public void setPersonShoppingCart(ArrayList<Product> personShoppingCart) {
        this.personShoppingCart = personShoppingCart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return personCash == person.personCash &&
                personName.equals(person.personName) &&
                Objects.equals(personShoppingCart, person.personShoppingCart);
    }

    @Override
    public int hashCode() {
        int result = personName == null ? 0 : personName.hashCode();
        result = 31 * result + personCash;
        for (Product product : personShoppingCart) {
            result = 31 * result + (product == null ? 0 : product.hashCode());
        }
        return result;
    }

    @Override
    public String toString() {
        return "Покупатель {" +
                "Имя покупателя: '" + personName + '\'' +
                ", Возраст покупателя: " + personAge +
                ", Деньги покупателя: " + personCash +
                ", Корзина с покупками: " + personShoppingCart +
                '}';
    }
}
