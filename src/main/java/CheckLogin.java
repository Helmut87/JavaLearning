import java.util.Scanner;

public class CheckLogin {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Введите логин:");
            String login = scanner.nextLine();

            System.out.println("Введите пароль:");
            String password = scanner.nextLine();

            System.out.println("Подтвердите пароль:");
            String confirmPassword = scanner.nextLine();

            User.validateUser(login, password, confirmPassword);
        }
    }
}