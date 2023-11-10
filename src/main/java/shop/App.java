package shop;

import com.github.javafaker.Faker;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Person> people = inputPeopleData();
        ArrayList<Product> products = generateRandomProductsWithDiscountAndWithoutDiscount();
        purchaseProducts(people, products);
        displayShoppingCart(people);
    }

    private static ArrayList<Person> inputPeopleData() {
        ArrayList<Person> people = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("������� ��� ������������ (��� ���������� ������� 'END' ������ ����� ����������):");
        while (true) {
            System.out.print("��� ������������: ");
            String name = scanner.nextLine();
            if (name.equals("END")) {
                break;
            }
            Person person = new Person();
            person.setPersonName(name);
            System.out.print("������ ����������: ");
            int cash = Integer.parseInt(scanner.nextLine());
            person.setPersonCash(cash);
            person.setPersonShoppingCart(new ArrayList<>());
            people.add(person);
        }

        return people;
    }

    private static ArrayList<Product> generateRandomProductsWithDiscountAndWithoutDiscount() {
        ArrayList<Product> products = new ArrayList<>();
        Locale locale = new Locale("ru_RU");
        Faker faker = new Faker(locale);
        for (int i = 0; i < 3; i++) {
            Product product = new Product();
            product.setProductName(faker.commerce().productName());
            product.setProductPrice(faker.number().numberBetween(1, 5000));
            products.add(product);
        }

        for (int i = 0; i < 3; i++) {
            Product product = new Product();
            product.setProductName(faker.commerce().productName());
            product.setProductPrice(faker.number().numberBetween(1, 5000));

            // ��������� ��������� ������
            if (faker.random().nextBoolean()) {
                int discountAmount = faker.number().numberBetween(1, 99);
                LocalDate expirationDate = LocalDate.now().plusDays(faker.number().numberBetween(1, 30));
                DiscountProduct discount = new DiscountProduct(discountAmount, expirationDate);
                product.setDiscount(discount);
            }

            products.add(product);
        }
        for (Product value : products) {
            System.out.println(value);
        }
        return products;
    }

    private static void purchaseProducts(ArrayList<Person> people, ArrayList<Product> products) {
        for (Person person : people) {
            for (Product product : products) {
                int priceToPay = product.getProductPrice();
                if (product.getDiscount() != null && !product.getDiscount().getExpirationDate().isBefore(LocalDate.now())) {
                    priceToPay -= product.getDiscount().getDiscountAmount();
                }
                if (priceToPay <= 0) {
                    priceToPay = 1;
                }
                if (person.getPersonCash() >= priceToPay) {
                    person.getPersonShoppingCart().add(product);
                    person.setPersonCash(person.getPersonCash() - priceToPay);
                } else {
                    System.out.println(person.getPersonName() + " �� ����� ��������� ���� " + product.getProductName());
                }
            }
        }
    }

    private static void displayShoppingCart(ArrayList<Person> people) {
        for (Person person : people) {
            if (person.getPersonShoppingCart().isEmpty()) {
                System.out.println(person.getPersonName() + " - ������ �� �������");
            } else {
                System.out.print(person.getPersonName() + " ����� : ");
                person.getPersonShoppingCart().forEach(product -> System.out.print(product.getProductName() + ", "));
                System.out.println();
            }
        }
    }
}