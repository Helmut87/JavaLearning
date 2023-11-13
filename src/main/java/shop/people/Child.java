package shop.people;

import shop.Person;
import shop.Product;

import java.util.ArrayList;

public class Child extends Person {
    public Child(String childName, int childMoney, int childAge, ArrayList<Product> personShoppingCart) {
        super(childName, childMoney, childAge, personShoppingCart);
    }
}
