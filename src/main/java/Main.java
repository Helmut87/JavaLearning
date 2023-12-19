import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("������� ������ (� ������������ �������, ����������� ��������)");
            System.out.println("���������� ������ ����: \"���\" \"���� ��������\" \"����� ��������\" \"���\" \"�������\"");
            String input = scanner.nextLine();

            String[] inputData = input.split("\\s+");

            if (inputData.length != 7) {
                throw new IllegalArgumentException("������! �������� ���������� �����.");
            }

            try {
                Person person = new Person(inputData[0], inputData[1], inputData[2], inputData[3],
                        Long.parseLong(inputData[4]), inputData[5].charAt(0), Integer.parseInt(inputData[6]));
                String resourcesDirectory = "src/main/java/files/";
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(resourcesDirectory + person.getLastName() + ".txt", true))) {
                    writer.write(person + System.lineSeparator());
                    System.out.println("������ ������� �������� � ����.");
                } catch (IOException e) {
                    System.err.println("������ ������ � ����!");
                    e.printStackTrace();
                }
            } catch (NumberFormatException e) {
                System.err.println("������: �������� ������ ������.");
                e.printStackTrace();
            }
        }
    }
}
