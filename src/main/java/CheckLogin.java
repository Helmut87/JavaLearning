import java.util.Scanner;

public class CheckLogin {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("������� �����:");
            String login = scanner.nextLine();

            System.out.println("������� ������:");
            String password = scanner.nextLine();

            System.out.println("����������� ������:");
            String confirmPassword = scanner.nextLine();

            User.validateUser(login, password, confirmPassword);
        }
    }
}