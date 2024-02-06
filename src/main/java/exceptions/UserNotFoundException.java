package exceptions;

public class UserNotFoundException extends Exception {
    public UserNotFoundException(String id) {
        super("Пользователь с идентификатором " + id + " не найден.");
    }
}
