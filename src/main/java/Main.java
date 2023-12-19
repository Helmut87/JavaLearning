import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите данные (в произвольном порядке, разделенные пробелом)");
            System.out.println("Необходимо ввести поля: \"ФИО\" \"дата рождения\" \"номер телефона\" \"пол\" \"возраст\"");
            String input = scanner.nextLine();

            String[] inputData = input.split("\\s+");

            if (inputData.length != 7) {
                throw new IllegalArgumentException("Ошибка! Неверное количество полей.");
            }

            try {
                Person person = new Person(inputData[0], inputData[1], inputData[2], inputData[3],
                        Long.parseLong(inputData[4]), inputData[5].charAt(0), Integer.parseInt(inputData[6]));
                String resourcesDirectory = "src/main/java/files/";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(resourcesDirectory + person.getLastName() + ".txt", true))) {
                    writer.write(person + System.lineSeparator());
                    System.out.println("Данные успешно записаны в файл.");
                } catch (IOException e) {
                    System.err.println("Ошибка записи в файл!");
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                System.err.println("Ошибка: Неверный формат данных.");
                e.printStackTrace();
            }
        }
    }
}
