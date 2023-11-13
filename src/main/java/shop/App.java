package shop;

import com.github.javafaker.Faker;
import shop.people.Adult;
import shop.people.Child;
import shop.people.Pensioner;

import java.time.LocalDate;
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
        ArrayList<Product> personShoppingCart = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("������� ������ � ����������� (��� ���������� ������� 'END' ������ ����� ����������):");
        while (true) {
            System.out.print("��� ����������: ");
            String name = scanner.nextLine();
            if (name.equals("END")) {
                break;
            }
            System.out.print("�������: ");
            int age = Integer.parseInt(scanner.nextLine());
            if (age >= 0 && age < 6) {
                throw new RuntimeException("������� �� ����� �������� ��������!");
            }

            System.out.print("������ ����������: ");
            int cash = Integer.parseInt(scanner.nextLine());

            if (age > 6 && age <= 17) {
                Child child = new Child(name, age, cash, personShoppingCart);
                people.add(child);
            } else if (age >= 18 && age <= 65) {
                System.out.print("����� ������ � ������ (true/false): ");
                boolean canBuyOnCredit = Boolean.parseBoolean(scanner.nextLine());
                Adult adult = new Adult(name, age, cash, canBuyOnCredit, personShoppingCart);
                people.add(adult);
            } else if (age >= 65) {
                Pensioner pensioner = new Pensioner(name, age, cash, personShoppingCart);
                people.add(pensioner);
            } else {
                throw new IllegalArgumentException("������������ ������� ����������!");
            }
        }

        return people;
    }

    private static ArrayList<Product> generateRandomProducts() {
        ArrayList<Product> products = new ArrayList<>();
        Locale locale = new Locale("ru_RU");
        Faker faker = new Faker(locale);
        for (int i = 0; i < 5; i++) {
            String productName = faker.commerce().productName();
            int productPrice = faker.number().numberBetween(1, 5000);
            // ��������� ��������� ������
            DiscountProduct discount = null;
            if (faker.random().nextBoolean()) {
                int discountAmount = faker.number().numberBetween(1, 99);
                LocalDate expirationDate = LocalDate.now().plusDays(faker.number().numberBetween(1, 30));
                discount = new DiscountProduct(discountAmount, expirationDate);
            }
            Product product = new Product(productName, productPrice, discount);
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
                if (product.getDiscount() != null &&
                        !product.getDiscount().getExpirationDate().isBefore(LocalDate.now())) {
                    priceToPay = priceToPay - product.getDiscount().getDiscountAmount();
                }
                //��������������� �������, ��� ���� �� ����� ���� ������ 1. ������� ������ �� ������������� 1.
                if (priceToPay <= 0) {
                    priceToPay = 1;
                }

                // ��������, ���� ���������� - ��������� �� ��� ����������� �������������� ������
                if (person instanceof Pensioner) {
                    priceToPay = (int) (priceToPay * 0.95); // �������������� ������ ��� �����������
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
                System.out.println(person.getPersonName() + " - ������ �� �����");
            } else {
                System.out.print(person.getPersonName() + " ����� : ");
                person.getPersonShoppingCart().forEach(product -> System.out.print(product.getProductName() + ", "));
            }
        }
    }
}