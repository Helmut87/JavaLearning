package exceptions;

public class UserAlreadyExistsException extends Exception {
    public UserAlreadyExistsException(String id) {
        super("Пользователь с идентификатором " + id + " уже существует.");
    }
}
