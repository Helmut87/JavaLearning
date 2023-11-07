package shop;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Person> people = inputPeopleData();
        ArrayList<Product> products = generateRandomProducts();
        purchaseProducts(people, products);
        displayShoppingCart(people);
    }

    private static ArrayList<Person> inputPeopleData() {
        ArrayList<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя (для завершения введите 'END' вместо имени покупателя):");
        while (true) {
            System.out.print("Имя пользователя: ");
            String name = scanner.nextLine();
            if (name.equals("END")) {
                break;
            }
            Person person = new Person();
            person.setPersonName(name);
            System.out.print("Деньги покупателя: ");
            int cash = Integer.parseInt(scanner.nextLine());
            person.setPersonCash(cash);
            person.setPersonShoppingCart(new ArrayList<>());
            people.add(person);
        }

        return people;
    }

    private static ArrayList<Product> generateRandomProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Locale locale = new Locale("ru_RU");
        Faker faker = new Faker(locale);
        for (int i = 0; i < 3; i++) {
            Product product = new Product();
            product.setProductName(faker.commerce().productName());
            product.setProductPrice(faker.number().numberBetween(1, 5000));
            products.add(product);
            System.out.println(products.get(i));
        }

        return products;
    }

    private static void purchaseProducts(ArrayList<Person> people, ArrayList<Product> products) {
        for (Person person : people) {
            for (Product product : products) {
                if (person.getPersonCash() >= product.getProductPrice()) {
                    person.getPersonShoppingCart().add(product);
                    person.setPersonCash(person.getPersonCash() - product.getProductPrice());
                } else {
                    System.out.println(person.getPersonName() + " не может позволить себе " + product.getProductName());
                }
            }
        }
    }

    private static void displayShoppingCart(ArrayList<Person> people) {
        for (Person person : people) {
            if (person.getPersonShoppingCart().isEmpty()) {
                System.out.println(person.getPersonName() + " - ничего не куплено");
            } else {
                System.out.print(person.getPersonName() + " купил : ");
                person.getPersonShoppingCart().forEach(product -> System.out.print(product.getProductName() + ", "));
                System.out.println();
            }
        }
    }
}