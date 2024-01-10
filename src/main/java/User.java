import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
@AllArgsConstructor
public class User {
    private String login;
    private String password;

    public static boolean validateUser(String login, String password, String confirmPassword) {
        try {
            UserValidator.validateLogin(login);
            UserValidator.validatePassword(password, confirmPassword);
            System.out.println("Регистрация прошла успешно!");
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Ошибка регистрации: " + e.getMessage());
            return false;
        }
    }
}
