package shop.people;

import shop.Person;
import shop.Product;

import java.util.ArrayList;

public class Pensioner extends Person {
    public Pensioner(String pensionerName, int pensionerMoney, int pensionerAge, ArrayList<Product> personShoppingCart) {
        super(pensionerName, pensionerMoney, pensionerAge, personShoppingCart);
    }
}