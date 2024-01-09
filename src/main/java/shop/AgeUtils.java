package shop;

import shop.people.Adult;
import shop.people.Child;
import shop.people.Pensioner;

import java.util.ArrayList;
import java.util.Scanner;

public class AgeUtils {
    public static Person createPersonByAge(String name, int age, int cash, Scanner scanner, ArrayList<Product> personShoppingCart) {
        if (age >= 0 && age < 6) {
            throw new RuntimeException("Ребенок не может покупать продукты!");
        } else if (age > 6 && age <= 17) {
            return new Child(name, age, cash, personShoppingCart);
        } else if (age >= 18 && age <= 65) {
            System.out.print("Может купить в кредит (true/false): ");
            boolean canBuyOnCredit = Boolean.parseBoolean(scanner.nextLine());
            return new Adult(name, age, cash, canBuyOnCredit, personShoppingCart);
        } else if (age >= 65) {
            return new Pensioner(name, age, cash, personShoppingCart);
        } else {
            throw new IllegalArgumentException("Некорректный возраст покупателя!");
        }
    }
}
