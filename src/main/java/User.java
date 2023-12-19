import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;
import lombok.Getter;
import lombok.Setter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Getter
@Setter
public class User {
    private String login;
    private String password;

    public User(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public static boolean validateUser(String login, String password, String confirmPassword) {
        try {
            validateLogin(login);
            validatePassword(password, confirmPassword);
            System.out.println("Регистрация прошла успешно!");
            return true;
        } catch (WrongLoginException | WrongPasswordException e) {
            System.err.println("Ошибка регистрации: " + e.getMessage());
            return false;
        }
    }

    private static void validateLogin(String login) throws WrongLoginException {
        if (login.isEmpty()) {
            throw new WrongLoginException("Логин не может быть пустой строкой!");
        }
        String loginRegex = "^[a-zA-Z0-9_]{1,20}$";
        Pattern pattern = Pattern.compile(loginRegex);
        Matcher matcher = pattern.matcher(login);

        if (!matcher.matches()) {
            throw new WrongLoginException();
        }
    }

    private static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.isEmpty()) {
            throw new WrongPasswordException("Пароль не может быть пустой строкой!");
        }

        String passwordRegex = "^[a-zA-Z0-9_]{1,20}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches() || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}
