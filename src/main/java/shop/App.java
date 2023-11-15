package shop;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class App {
    private static FileWriter writer;

    public static void main(String[] args) throws IOException {
        writer = new FileWriter("output.txt");
        ArrayList<Person> people = readPeopleDataFromFile();
        ArrayList<Product> products = generateRandomProducts();
        purchaseProducts(people, products);
        displayShoppingCart(people);
        writer.close();
    }

    private static HashMap<String, Integer> readFileData(String fileName) {
        Scanner scanner;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("src/main/resources/").append(fileName).append(".txt");
            String filePath = sb.toString();
            scanner = new Scanner(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        HashMap<String, Integer> resultMap = new HashMap<>();
        while (scanner.hasNextLine()) {
            String[] columns = scanner.nextLine().split(" = ");
            resultMap.put(columns[0], Integer.parseInt(columns[1]));
        }
        return resultMap;
    }

    private static ArrayList<Person> readPeopleDataFromFile() {
        ArrayList<Person> people = new ArrayList<>();
        HashMap<String, Integer> mapOfPersons = readFileData("persons");
        Set<Map.Entry<String, Integer>> set = mapOfPersons.entrySet();
        for (Map.Entry<String, Integer> mapData : set) {
            Person person = new Person();
            person.setPersonName(mapData.getKey());
            person.setPersonCash(mapData.getValue());
            person.setPersonShoppingCart(new ArrayList<>());
            people.add(person);
        }

        return people;
    }

    private static ArrayList<Product> generateRandomProducts() {
        ArrayList<Product> products = new ArrayList<>();
        HashMap<String, Integer> mapOfProducts = readFileData("products");
        Set<Map.Entry<String, Integer>> set = mapOfProducts.entrySet();
        for (Map.Entry<String, Integer> mapData : set) {
            Product product = new Product();
            product.setProductName(mapData.getKey());
            product.setProductPrice(mapData.getValue());
            products.add(product);
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
                    try {
                        writer.write(person.getPersonName() + " не может позволить себе: " +
                                product.getProductName() +
                                System.getProperty("line.separator"));
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                }
            }
        }
    }

    private static void displayShoppingCart(ArrayList<Person> people) {
        for (Person person : people) {
            if (person.getPersonShoppingCart().isEmpty()) {
                try {
                    writer.write(person.getPersonName() + " - ничего не куплено" + System.getProperty("line.separator"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            } else {
                String cartItems = String.join(", ", person.getPersonShoppingCart().toString());
                cartItems = cartItems.substring(1, cartItems.length() - 1);
                try {
                    writer.write(person.getPersonName() + " купил: " +
                            cartItems
                            + System.getProperty("line.separator"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}