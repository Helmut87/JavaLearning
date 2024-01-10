import exceptions.WrongLoginException;
import exceptions.WrongPasswordException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator {
    public static void validateLogin(String login) throws WrongLoginException {
        if (login.isEmpty()) {
            throw new WrongLoginException("����� �� ����� ���� ������ �������!");
        }
        String loginRegex = "^[a-zA-Z0-9_]{1,20}$";
        Pattern pattern = Pattern.compile(loginRegex);
        Matcher matcher = pattern.matcher(login);

        if (!matcher.matches()) {
            throw new WrongLoginException();
        }
    }

    public static void validatePassword(String password, String confirmPassword) throws WrongPasswordException {
        if (password.isEmpty()) {
            throw new WrongPasswordException("������ �� ����� ���� ������ �������!");
        }

        String passwordRegex = "^[a-zA-Z0-9_]{1,20}$";
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(password);

        if (!matcher.matches() || !password.equals(confirmPassword)) {
            throw new WrongPasswordException();
        }
    }
}
